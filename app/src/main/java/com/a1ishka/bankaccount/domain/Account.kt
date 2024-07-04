package com.a1ishka.bankaccount.domain

data class Account(
    val accountId: Long? = 0,
    val name: String,
    val accountNumber: Long,
    val cardNumber: Long
)