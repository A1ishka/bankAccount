package com.a1ishka.bankaccount.presentation.transaction

import com.a1ishka.bankaccount.data.entity.TransactionEntity

data class TransactionState(
    val transactionList: List<TransactionEntity> = emptyList(),
    val applier: String = "",
    val number: String = "",
    val date: String = "",
    val status: String = "",
    val amount: String = "",
    val accountId: Long = 0,
    val startDate: String = "",
    val endDate: String = "",
    val isTransactionVerified: Boolean = true
)