package com.a1ishka.bankaccount.screens.accountDashboard.accountChoosingBottomSheet

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.a1ishka.bankaccount.data.Account


@Composable
fun AccountList(
    accounts: List<Account>,
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableStateOf(accounts[0]) }

    LazyColumn(
        modifier = modifier.padding(top = 20.dp, bottom = 80.dp),
    ) {
        items(accounts) { item ->
            AccountItem(
                account = item,
                isSelected = item == selectedItem,
                onClick = { selectedItem = item })
        }
    }
}