package com.a1ishka.bankaccount.domain.repository

import com.a1ishka.bankaccount.data.entity.AccountEntity
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    fun getAccounts(): Flow<List<AccountEntity>>

    fun getAccount(accountId: Long): AccountEntity

    suspend fun upsertAccount(account: AccountEntity)

    suspend fun deleteAccount(account: AccountEntity)
}