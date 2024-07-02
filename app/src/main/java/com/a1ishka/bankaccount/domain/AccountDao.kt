package com.a1ishka.bankaccount.domain

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.a1ishka.bankaccount.data.entity.AccountEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {
    @Query("SELECT * FROM AccountEntity")
    fun getAccounts(): Flow<List<AccountEntity>>

    @Query("SELECT * FROM AccountEntity WHERE accountId = :accountId")
    fun getAccount(accountId: Long): AccountEntity

    @Upsert
    suspend fun upsertAccount(account: AccountEntity)

    @Delete
    suspend fun deleteAccount(account: AccountEntity)
}