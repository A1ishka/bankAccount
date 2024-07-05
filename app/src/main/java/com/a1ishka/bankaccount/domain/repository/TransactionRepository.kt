package com.a1ishka.bankaccount.domain.repository

import com.a1ishka.bankaccount.data.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    fun getTransactions(accountId: Long): Flow<List<TransactionEntity>>
    fun getTransaction(transactionId: Long): Flow<TransactionEntity>
    fun getFilteredTransactions(
        accountId: Long,
        startDate: String,
        endDate: String
    ): Flow<List<TransactionEntity>>

    suspend fun upsertTransaction(transaction: TransactionEntity)
    suspend fun deleteTransaction(transaction: TransactionEntity)
}