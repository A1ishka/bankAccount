package com.a1ishka.bankaccount.util

import com.a1ishka.bankaccount.data.entity.AccountEntity
import com.a1ishka.bankaccount.data.entity.TransactionEntity
import com.a1ishka.bankaccount.domain.Account
import com.a1ishka.bankaccount.domain.Transaction

fun Account.toAccountEntity() = AccountEntity(
    accountId = accountId!!,
    name = name,
    accountNumber = accountNumber,
    cardNumber = cardNumber
)

fun AccountEntity.toAccount() = Account(
    accountId = accountId,
    name = name,
    accountNumber = accountNumber,
    cardNumber = cardNumber
)

fun List<AccountEntity>.toAccountList() = map { it.toAccount() }

fun List<Account>.toAccountEntityList() = map { it.toAccountEntity() }

fun Transaction.toTransactionEntity() = TransactionEntity(
    transactionId = transactionId!!,
    accountId = accountId,
    applier = applier,
    number = number,
    date = date,
    status = status,
    amount = amount
)

fun TransactionEntity.toTransaction() = Transaction(
    transactionId = transactionId,
    accountId = accountId,
    applier = applier,
    number = number,
    date = date,
    status = status,
    amount = amount
)

fun List<TransactionEntity>.toTransactionList() = map { it.toTransaction() }

fun List<Transaction>.toTransactionEntityList() = map { it.toTransactionEntity() }