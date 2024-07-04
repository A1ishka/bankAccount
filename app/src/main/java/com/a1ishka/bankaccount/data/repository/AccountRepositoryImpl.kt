package com.a1ishka.bankaccount.data.repository

import com.a1ishka.bankaccount.data.AccountDao
import com.a1ishka.bankaccount.data.entity.AccountEntity
import com.a1ishka.bankaccount.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow


class AccountRepositoryImpl(private val accountDao: AccountDao) : AccountRepository {
    override fun getAccounts(): Flow<List<AccountEntity>> = accountDao.getAccounts()
    override fun getAccount(accountId: Long): AccountEntity = accountDao.getAccount(accountId)
    override suspend fun upsertAccount(account: AccountEntity) {
        accountDao.upsertAccount(account)
    }

    override suspend fun deleteAccount(account: AccountEntity) {
        accountDao.deleteAccount(account)
    }
}