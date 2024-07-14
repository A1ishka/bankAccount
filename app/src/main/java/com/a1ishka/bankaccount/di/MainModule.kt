package com.a1ishka.bankaccount.di

import android.app.Application
import androidx.room.Room
import com.a1ishka.bankaccount.data.AppDatabase
import com.a1ishka.bankaccount.data.dao.AccountDao
import com.a1ishka.bankaccount.data.dao.TransactionDao
import com.a1ishka.bankaccount.data.repository.AccountRepositoryImpl
import com.a1ishka.bankaccount.data.repository.TransactionRepositoryImpl
import com.a1ishka.bankaccount.domain.repository.AccountRepository
import com.a1ishka.bankaccount.domain.repository.TransactionRepository
import com.a1ishka.bankaccount.presentation.account.AccountViewModel
import com.a1ishka.bankaccount.presentation.transaction.TransactionViewModel
import com.a1ishka.bankaccount.presentation.transaction.transactionDetails.TransactionDetailsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    @Singleton
    fun providesAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTransactionDao(database: AppDatabase): TransactionDao {
        return database.transactionDao
    }

    @Provides
    @Singleton
    fun provideAccountDao(database: AppDatabase): AccountDao {
        return database.accountDao
    }

    @Provides
    @Singleton
    fun provideTransactionRepository(
        transactionDao: TransactionDao
    ): TransactionRepository {
        return TransactionRepositoryImpl(transactionDao)
    }

    @Provides
    @Singleton
    fun provideAccountRepository(
        accountDao: AccountDao
    ): AccountRepository {
        return AccountRepositoryImpl(accountDao)
    }

    @Provides
    @Singleton
    fun provideTransactionViewModel(
        transactionRepository: TransactionRepository
    ): TransactionViewModel {
        return TransactionViewModel(transactionRepository)
    }

//    @Provides
//    @Singleton
//    fun provideTransactionDetailsViewModel(
//        transactionRepository: TransactionRepository
//    ): TransactionDetailsViewModel {
//        return TransactionDetailsViewModel(transactionRepository)
//    }

    @Provides
    @Singleton
    fun provideAccountViewModel(
        accountRepository: AccountRepository
    ): AccountViewModel {
        return AccountViewModel(accountRepository)
    }
}