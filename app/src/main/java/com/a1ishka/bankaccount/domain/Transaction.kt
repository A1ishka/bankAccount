package com.a1ishka.bankaccount.domain

data class Transaction(
    val transactionId: Long? = 0,
    val accountId: Long,
    val applier: String,
    val number: String,
    val date: String,
    val status: String,
    val amount: String
)