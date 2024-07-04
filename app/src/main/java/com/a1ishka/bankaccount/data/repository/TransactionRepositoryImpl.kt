package com.a1ishka.bankaccount.data.repository

import com.a1ishka.bankaccount.data.TransactionDao
import com.a1ishka.bankaccount.data.entity.TransactionEntity
import com.a1ishka.bankaccount.domain.repository.TransactionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext


class TransactionRepositoryImpl(private val transactionDao: TransactionDao) :
    TransactionRepository {
    override fun getTransactions(accountId: Long): Flow<List<TransactionEntity>> =
        transactionDao.getTransactions(accountId)

    override fun getTransaction(transactionId: Long): TransactionEntity =
        transactionDao.getTransaction(transactionId)

    override fun getFilteredTransactions(
        accountId: Long,
        startDate: String,
        endDate: String
    ): Flow<List<TransactionEntity>> {
        return transactionDao.getFilteredTransactions(accountId, startDate, endDate)
    }

    override suspend fun upsertTransaction(transaction: TransactionEntity) {
        withContext(Dispatchers.IO) {
            transactionDao.upsertTransaction(transaction)
        }
    }

    override suspend fun deleteTransaction(transaction: TransactionEntity) {
        withContext(Dispatchers.IO) {
            transactionDao.deleteTransaction(transaction)
        }
    }
}