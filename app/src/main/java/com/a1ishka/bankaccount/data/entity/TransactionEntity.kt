package com.a1ishka.bankaccount.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val transactionId: Long? = 0,
    val accountId: Long,
    val applier: String,
    val number: String,
    val date: String,
    val status: String,
    val amount: String
)
