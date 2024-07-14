package com.a1ishka.bankaccount.presentation.account

import com.a1ishka.bankaccount.domain.Account

data class AccountState(
    val accountList: List<Account> = emptyList(),
    val currentAccount: Account? = null,
    val name: String = "",
    val cardNumber: Long = 0,
    val accountNumber: Long = 0,
    val isAccountVerified: Boolean = true,
    val isLoading: Boolean = false
)