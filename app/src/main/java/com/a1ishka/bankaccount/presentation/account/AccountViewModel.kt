package com.a1ishka.bankaccount.presentation.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a1ishka.bankaccount.data.entity.AccountEntity
import com.a1ishka.bankaccount.domain.Account
import com.a1ishka.bankaccount.domain.repository.AccountRepository
import com.a1ishka.bankaccount.util.Resource
import com.a1ishka.bankaccount.util.toAccount
import com.a1ishka.bankaccount.util.toAccountEntity
import com.a1ishka.bankaccount.util.toAccountList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val accountRepository: AccountRepository
) : ViewModel() {
    private val _state = MutableStateFlow(AccountState())
    val accountState: StateFlow<AccountState> = _state

    private var getAccountsJob: Job? = null

    init {
        getAccounts()
    }

    fun getAccounts() {
        getAccountsJob?.cancel()
        getAccountsJob = accountRepository.getAccounts().onEach { result ->
            when (result) {
                is Resource.Success<*> -> {
                    if (result.data != null) {
                        _state.value = accountState.value.copy(
                            accountList = (result.data as List<AccountEntity>).toAccountList(),
                            currentAccount = result.data[0].toAccount(),
                            isLoading = false
                        )
                    }
                }

                is Resource.Error<*> -> {
                    println(result.message)
                }

                is Resource.Loading<*> -> {
                    _state.value = accountState.value.copy(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onAccountEvent(event: AccountEvent) {
        when (event) {
            is AccountEvent.SaveAccount -> {
                val accountId = _state.value.currentAccount?.accountId ?: 0
                val name = _state.value.name
                val cardNumber = _state.value.cardNumber
                val accountNumber = _state.value.accountNumber

                if (name.isBlank() || cardNumber == 0L || accountNumber == 0L) {
                    _state.update { it.copy(isAccountVerified = false) }
                    return
                }

                _state.update { it.copy(isAccountVerified = true) }
                val account = Account(
                    accountId = accountId,
                    name = name,
                    cardNumber = cardNumber,
                    accountNumber = accountNumber
                )
                viewModelScope.launch {
                    accountRepository.upsertAccount(account.toAccountEntity())
                }
            }

            is AccountEvent.DeleteAccount -> {
                viewModelScope.launch {
                    accountRepository.deleteAccount(event.account.toAccountEntity())
                }
            }

            is AccountEvent.SetAccountName -> {
                _state.update { it.copy(name = event.name) }
            }

            is AccountEvent.SetCardNumber -> {
                _state.update { it.copy(cardNumber = event.cardNumber) }
            }

            is AccountEvent.SetAccountNumber -> {
                _state.update { it.copy(accountNumber = event.accountNumber) }
            }

            is AccountEvent.SetCurrentAccount -> {
                _state.update { it.copy(currentAccount = event.account) }
            }
        }
    }
}