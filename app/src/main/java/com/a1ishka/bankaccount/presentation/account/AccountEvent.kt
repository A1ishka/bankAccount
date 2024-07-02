package com.a1ishka.bankaccount.presentation.account

import com.a1ishka.bankaccount.data.entity.AccountEntity

sealed interface AccountEvent {
    object SaveAccount : AccountEvent
    data class DeleteAccount(val account: AccountEntity) : AccountEvent
    data class SetAccountName(val name: String) : AccountEvent
    data class SetCardNumber(val cardNumber: Long) : AccountEvent
    data class SetAccountNumber(val accountNumber: Long) : AccountEvent
}