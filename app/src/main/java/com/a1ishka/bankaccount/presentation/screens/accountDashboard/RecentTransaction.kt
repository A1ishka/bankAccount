package com.a1ishka.bankaccount.presentation.screens.accountDashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.a1ishka.bankaccount.data.local_data.Transaction

@Composable
fun RecentTransactions(
    transactions:  List<Transaction>,
    modifier: Modifier = Modifier
) {    
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(49, 49, 54, 255))
    ) {
        LazyColumn(
            modifier = modifier,
        ) {
            items(transactions) { item ->
                TransactionItem(transaction = item)
            }
        }
    }
}