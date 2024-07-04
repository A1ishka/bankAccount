package com.a1ishka.bankaccount.presentation.transaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a1ishka.bankaccount.data.repository.TransactionRepositoryImpl
import com.a1ishka.bankaccount.domain.Transaction
import com.a1ishka.bankaccount.domain.repository.TransactionRepository
import com.a1ishka.bankaccount.util.toTransactionEntity
import com.a1ishka.bankaccount.util.toTransactionList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {
    private val _state = MutableStateFlow(TransactionState())
    val transactionState: MutableStateFlow<TransactionState> = _state

    init {
        viewModelScope.launch {
            transactionRepository.getTransactions(accountId = _state.value.accountId).collect { transactions ->
                _state.update { it.copy(transactionList = transactions.toTransactionList()) }
            }
        }
    }

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
                val transaction = Transaction(
                    accountId = accountId,
                    applier = applier,
                    number = number,
                    date = date,
                    status = status,
                    amount = amount
                )
                viewModelScope.launch {
                    transactionRepository.upsertTransaction(transaction.toTransactionEntity())
                }
            }

            is TransactionEvent.DeleteTransaction -> {
                viewModelScope.launch {
                    transactionRepository.deleteTransaction(event.transaction.toTransactionEntity())
                }
            }

            is TransactionEvent.FilterTransactions -> {
                viewModelScope.launch {
                    transactionRepository.getFilteredTransactions(
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
