package com.a1ishka.bankaccount.presentation.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a1ishka.bankaccount.data.entity.AccountEntity
import com.a1ishka.bankaccount.domain.AccountDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountViewModel @Inject constructor(
    private val accountDao: AccountDao
) : ViewModel() {
    private val _state = MutableStateFlow(AccountState())
    val accountState: MutableStateFlow<AccountState> = _state

    fun onAccountEvent(event: AccountEvent) {
        when (event) {
            is AccountEvent.SaveAccount -> {
                val name = _state.value.name
                val cardNumber = _state.value.cardNumber
                val accountNumber = _state.value.accountNumber

                if (name.isBlank() || cardNumber == 0L || accountNumber == 0L) {
                    _state.update { it.copy(isAccountVerified = false) }
                    return
                }

                _state.update { it.copy(isAccountVerified = true) }
                val account = AccountEntity(
                    name = name,
                    cardNumber = cardNumber,
                    accountNumber = accountNumber
                )
                viewModelScope.launch {
                    accountDao.upsertAccount(account)
                }
            }

            is AccountEvent.DeleteAccount -> {
                viewModelScope.launch {
                    accountDao.deleteAccount(event.account)
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