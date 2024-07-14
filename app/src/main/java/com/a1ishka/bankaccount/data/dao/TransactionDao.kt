package com.a1ishka.bankaccount.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.a1ishka.bankaccount.data.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Query("SELECT * FROM TransactionEntity WHERE accountId = :accountId")
    fun getTransactions(accountId: Long): Flow<List<TransactionEntity>>

    @Query("SELECT * FROM TransactionEntity WHERE transactionId = :transactionId")
    fun getTransaction(transactionId: Long): Flow<TransactionEntity>

    @Query("SELECT * FROM TransactionEntity WHERE accountId = :accountId AND date BETWEEN :startDate AND :endDate")
    fun getFilteredTransactions(
        accountId: Long,
        startDate: String,
        endDate: String
    ): Flow<List<TransactionEntity>>

    @Upsert
    suspend fun upsertTransaction(transaction: TransactionEntity)

    @Delete
    suspend fun deleteTransaction(transaction: TransactionEntity)
}