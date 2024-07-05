package com.a1ishka.bankaccount.presentation.transaction.transactionDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a1ishka.bankaccount.domain.repository.TransactionRepository
import com.a1ishka.bankaccount.presentation.transaction.TransactionState
import com.a1ishka.bankaccount.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TransactionDetailsViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {
    private val _transaction = MutableStateFlow(TransactionState())
    val transactionState: StateFlow<TransactionState> = _transaction

    private var getTransactionsJob: Job? = null

    init {
        getTransaction()
    }

     fun getTransaction() {
        getTransactionsJob?.cancel()
        getTransactionsJob =
            transactionRepository.getTransaction(transactionId = _transaction.value.transactionId)
                .onEach { result ->
//                    when (result) {
//                        is Resource.Success<*> -> {
//                            if (result.data != null) {
//                                _transaction.value = transactionState.value.copy(
//                                    applier = transactionState.value.applier,
//                                    number = transactionState.value.number,
//                                    date = transactionState.value.date,
//                                    status = transactionState.value.status,
//                                    amount = transactionState.value.amount,
//                                    accountId = transactionState.value.accountId,
//                                    isLoading = false
//                                )
//                            }
//                        }
//
//                        is Resource.Error<*> -> {
//                            println(result.message)
//                        }
//
//                        is Resource.Loading<*> -> {
//                            _transaction.value = transactionState.value.copy(isLoading = true)
//                        }
//                    }
                }.launchIn(viewModelScope)
    }
}