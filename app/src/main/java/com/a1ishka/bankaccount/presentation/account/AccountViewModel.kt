package com.a1ishka.bankaccount.presentation.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a1ishka.bankaccount.data.repository.AccountRepositoryImpl
import com.a1ishka.bankaccount.domain.Account
import com.a1ishka.bankaccount.domain.repository.AccountRepository
import com.a1ishka.bankaccount.util.toAccount
import com.a1ishka.bankaccount.util.toAccountEntity
import com.a1ishka.bankaccount.util.toAccountList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val accountRepository: AccountRepository
) : ViewModel() {
    private val _state = MutableStateFlow(AccountState())
    val accountState: MutableStateFlow<AccountState> = _state

    init {
        viewModelScope.launch {
            accountRepository.getAccounts().collect { accounts ->
                _state.update { it.copy(accountList = accounts.toAccountList()) }
            }
            _state.update { it.copy(currentAccount = accountRepository.getAccount(0).toAccount()) }
        }
    }

    fun onAccountEvent(event: AccountEvent) {
        when (event) {
            is AccountEvent.SaveAccount -> {
                val accountId = _state.value.currentAccount?.accountId
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
        }
    }
}