package com.a1ishka.bankaccount.presentation.transaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a1ishka.bankaccount.data.entity.TransactionEntity
import com.a1ishka.bankaccount.domain.TransactionDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


class TransactionViewModel @Inject constructor(
    private val transactionDao: TransactionDao
) : ViewModel() {
    private val _state = MutableStateFlow(TransactionState())
    val transactionState: MutableStateFlow<TransactionState> = _state

    fun onTransactionEvent(event: TransactionEvent) {
        when (event) {
            is TransactionEvent.SaveTransaction -> {
                val applier = _state.value.applier
                val number = _state.value.number
                val date = _state.value.date
                val status = _state.value.status
                val amount = _state.value.amount
                val accountId = _state.value.accountId

                if (applier.isBlank() || number.isBlank() || date.isBlank() || status.isBlank() || amount.isBlank()) {
                    _state.update { it.copy(isTransactionVerified = false) }
                    return
                }

                _state.update { it.copy(isTransactionVerified = true) }
                val transaction = TransactionEntity(
                    accountId = accountId,
                    applier = applier,
                    number = number,
                    date = date,
                    status = status,
                    amount = amount
                )
                viewModelScope.launch {
                    transactionDao.upsertTransaction(transaction)
                }
            }

            is TransactionEvent.DeleteTransaction -> {
                viewModelScope.launch {
                    transactionDao.deleteTransaction(event.transaction)
                }
            }

            is TransactionEvent.FilterTransactions -> {
                viewModelScope.launch {
                    transactionDao.getFilteredTransactions(
                        event.accountId,
                        event.startDate,
                        event.endDate
                    )
                }
            }

            is TransactionEvent.SetAmount -> {
                _state.update { it.copy(amount = event.amount) }
            }

            is TransactionEvent.SetApplier -> {
                _state.update { it.copy(applier = event.applier) }
            }

            is TransactionEvent.SetDate -> {
                _state.update { it.copy(date = event.date) }
            }

            is TransactionEvent.SetNumber -> {
                _state.update { it.copy(number = event.number) }
            }

            is TransactionEvent.SetStatus -> {
                _state.update { it.copy(status = event.status) }
            }

            is TransactionEvent.SetAccount -> {
                _state.update { it.copy(accountId = event.accountId) }
            }
        }
    }
}
