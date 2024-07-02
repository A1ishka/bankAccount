package com.a1ishka.bankaccount.data.repository

import com.a1ishka.bankaccount.domain.TransactionDao
import com.a1ishka.bankaccount.data.entity.TransactionEntity
import com.a1ishka.bankaccount.data.transactionData
import com.a1ishka.bankaccount.domain.repository.TransactionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext

// for multiple datasources (demo with ready lists)

class TransactionRepositoryImpl(private val transactionDao: TransactionDao) :
    TransactionRepository {

    override fun getTransactions(accountId: Long): Flow<List<TransactionEntity>> {
        return transactionDao.getTransactions(accountId)
            .flatMapConcat { transactionDataList ->
                if (transactionDataList.isEmpty()) {
                    flowOf(transactionData.map { transaction ->
                        TransactionEntity(
                            accountId = accountId,
                            applier = transaction.applier,
                            number = transaction.number,
                            date = transaction.date,
                            status = transaction.status,
                            amount = transaction.amount
                        )
                    })
                } else {
                    flowOf(transactionDataList)
                }
            }
    }

    override fun getTransaction(transactionId: Long): TransactionEntity {
        val transaction = transactionDao.getTransaction(transactionId)
        return if (transaction != null) {
            transaction
        } else {
            val transactionData = transactionData.find { it.transactionId == transactionId }
            if (transactionData != null) {
                TransactionEntity(
                    transactionId = transactionData.transactionId,
                    accountId = transactionData.accountId,
                    applier = transactionData.applier,
                    number = transactionData.number,
                    date = transactionData.date,
                    status = transactionData.status,
                    amount = transactionData.amount
                )
            } else {
                throw NoSuchElementException("Transaction not found")
            }
        }
    }

    override fun getFilteredTransactions(
        accountId: Long,
        startDate: String,
        endDate: String
    ): Flow<List<TransactionEntity>> {
        return transactionDao.getFilteredTransactions(accountId, startDate, endDate)
            .flatMapConcat { filteredTransactions ->
                if (filteredTransactions.isEmpty()) {
                    val transactionsInRange = transactionData.filter { transaction ->
                        transaction.accountId == accountId &&
                                transaction.date >= startDate &&
                                transaction.date <= endDate
                    }
                    flowOf(transactionsInRange.map { transaction ->
                        TransactionEntity(
                            transactionId = transaction.transactionId,
                            accountId = transaction.accountId,
                            applier = transaction.applier,
                            number = transaction.number,
                            date = transaction.date,
                            status = transaction.status,
                            amount = transaction.amount
                        )
                    })
                } else {
                    flowOf(filteredTransactions)
                }
            }
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

// for single datasource

//class TransactionRepositoryImpl(private val transactionDao: TransactionDao) :
//    TransactionRepository {
//    override fun getTransactions(accountId: Long): Flow<List<TransactionEntity>> =
//        transactionDao.getTransactions(accountId)
//
//    override fun getTransaction(transactionId: Long): TransactionEntity =
//        transactionDao.getTransaction(transactionId)
//
//    override fun getFilteredTransactions(
//        accountId: Long,
//        startDate: String,
//        endDate: String
//    ): Flow<List<TransactionEntity>> {
//        return transactionDao.getFilteredTransactions(accountId, startDate, endDate)
//    }
//
//    override suspend fun upsertTransaction(transaction: TransactionEntity) {
//        withContext(Dispatchers.IO) {
//            transactionDao.upsertTransaction(transaction)
//        }
//    }
//
//    override suspend fun deleteTransaction(transaction: TransactionEntity) {
//        withContext(Dispatchers.IO) {
//            transactionDao.deleteTransaction(transaction)
//        }
//    }
//}