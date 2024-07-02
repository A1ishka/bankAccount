package com.a1ishka.bankaccount.data.repository

import com.a1ishka.bankaccount.domain.AccountDao
import com.a1ishka.bankaccount.data.accountData
import com.a1ishka.bankaccount.data.entity.AccountEntity
import com.a1ishka.bankaccount.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf

// for multiple datasources (demo with ready lists)

class AccountRepositoryImpl(private val accountDao: AccountDao) : AccountRepository {
    override fun getAccounts(): Flow<List<AccountEntity>> {
        return accountDao.getAccounts()
            .flatMapConcat { accountDataList ->
                if (accountDataList.isEmpty()) {
                    flowOf(accountData.map { account ->
                        AccountEntity(
                            accountId = account.accountId,
                            name = account.name,
                            accountNumber = account.accountNumber,
                            cardNumber = account.cardNumber
                        )
                    })
                } else {
                    flowOf(accountDataList)
                }
            }
    }

    override fun getAccount(accountId: Long): AccountEntity {
        val account = accountDao.getAccount(accountId)
        return if (account != null) {
            account
        } else {
            val accountData = accountData.find { it.accountId == accountId }
            if (accountData != null) {
                AccountEntity(
                    accountId = accountData.accountId,
                    name = accountData.name,
                    accountNumber = accountData.accountNumber,
                    cardNumber = accountData.cardNumber
                )
            } else {
                throw NoSuchElementException("Account not found")
            }
        }
    }

    override suspend fun upsertAccount(account: AccountEntity) {
        accountDao.upsertAccount(account)
    }

    override suspend fun deleteAccount(account: AccountEntity) {
        accountDao.deleteAccount(account)
    }
}

// for single datasource

//class AccountRepositoryImpl(private val accountDao: AccountDao) : AccountRepository {
//    override fun getAccounts(): Flow<List<AccountEntity>> = accountDao.getAccounts()
//    override fun getAccount(accountId: Long): AccountEntity = accountDao.getAccount(accountId)
//    override suspend fun upsertAccount(account: AccountEntity) { accountDao.upsertAccount(account) }
//    override suspend fun deleteAccount(account: AccountEntity) { accountDao.deleteAccount(account) }
//}