package com.a1ishka.bankaccount.presentation.transaction

import com.a1ishka.bankaccount.domain.Transaction

sealed interface TransactionEvent {
    object SaveTransaction : TransactionEvent
    data class FilterTransactions(val accountId: Long, val startDate: String, val endDate: String) :
        TransactionEvent

    data class DeleteTransaction(val transaction: Transaction) : TransactionEvent
    data class SetApplier(val applier: String) : TransactionEvent
    data class SetNumber(val number: String) : TransactionEvent
    data class SetDate(val date: String) : TransactionEvent
    data class SetStatus(val status: String) : TransactionEvent
    data class SetAmount(val amount: String) : TransactionEvent
    data class SetAccount(val accountId: Long) : TransactionEvent
}