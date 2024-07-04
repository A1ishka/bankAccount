package com.a1ishka.bankaccount.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.a1ishka.bankaccount.data.entity.AccountEntity
import com.a1ishka.bankaccount.data.entity.TransactionEntity

@Database(entities = [AccountEntity::class, TransactionEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val accountDao: AccountDao
    abstract val transactionDao: TransactionDao
}