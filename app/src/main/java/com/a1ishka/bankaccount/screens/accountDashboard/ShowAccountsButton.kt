package com.a1ishka.bankaccount.screens.accountDashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.a1ishka.bankaccount.R


@Composable
fun ShowAccountsButton(
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier
            .padding(horizontal = 5.dp),
        onClick = { /*TODO*/ }
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_chevron_forward),
            contentDescription = "To Choose Account",
        )
    }
}