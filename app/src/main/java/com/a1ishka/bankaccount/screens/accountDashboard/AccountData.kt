package com.a1ishka.bankaccount.screens.accountDashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.a1ishka.bankaccount.data.Account


@Composable
fun AccountData(
    account: Account,
    modifier: Modifier = Modifier
) {
    val lastFourDigits = account.cardNumber % 10000
    val accountCardNumber = "•••• $lastFourDigits "
    Column(
        modifier = modifier
            .fillMaxWidth(1f)
            .padding(10.dp)
    ) {
        Text(
            text = account.name,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
        Text(
            text = account.accountNumber.toString(),
            color = Color.Gray
        )
        Text(
            text = accountCardNumber,
            color = Color.Gray
        )
    }
}