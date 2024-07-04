package com.a1ishka.bankaccount.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val accountId: Long,
    val name: String,
    val accountNumber: Long,
    val cardNumber: Long
)