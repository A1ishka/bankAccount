package com.a1ishka.bankaccount.screens.accountDashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.a1ishka.bankaccount.R
import com.a1ishka.bankaccount.screens.accountDashboard.accountChoosingBottomSheet.BottomSheet


@Composable
fun ShowAccountsButton(
    modifier: Modifier = Modifier
) {
    var showAccountBottomSheet by remember { mutableStateOf(false) }

    if (showAccountBottomSheet) {
        BottomSheet() {
            showAccountBottomSheet = false
        }
    }

    IconButton(
        modifier = modifier
            .padding(horizontal = 5.dp),
        onClick = { showAccountBottomSheet = true }
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_chevron_forward),
            contentDescription = "To Choose Account",
        )
    }
}