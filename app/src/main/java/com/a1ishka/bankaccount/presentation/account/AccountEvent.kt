package com.a1ishka.bankaccount.presentation.account

import com.a1ishka.bankaccount.domain.Account

sealed interface AccountEvent {
    object SaveAccount : AccountEvent
    data class SetCurrentAccount(val account: Account) : AccountEvent
    data class DeleteAccount(val account: Account) : AccountEvent
    data class SetAccountName(val name: String) : AccountEvent
    data class SetCardNumber(val cardNumber: Long) : AccountEvent
    data class SetAccountNumber(val accountNumber: Long) : AccountEvent
}