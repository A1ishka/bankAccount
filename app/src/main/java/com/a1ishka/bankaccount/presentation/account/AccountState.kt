package com.a1ishka.bankaccount.presentation.account

import com.a1ishka.bankaccount.data.entity.AccountEntity

data class AccountState(
    val accountList: List<AccountEntity> = emptyList(),
    val currentAccount: AccountEntity? = null,
    val name: String = "",
    val cardNumber: Long = 0,
    val accountNumber: Long = 0,
    val isAccountVerified: Boolean = true
)