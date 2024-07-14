package com.a1ishka.bankaccount.presentation.screens.accountDashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a1ishka.bankaccount.R
import com.a1ishka.bankaccount.domain.Transaction


@Composable
fun TransactionItem(
    transaction: Transaction,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val textColor = when (transaction.status) {
        "Executed" -> Color(82, 171, 91)
        "Declined" -> Color(245, 103, 94)
        "In progress" -> Color(241, 191, 55)
        else -> Color.White
    }//instead of state to simplify

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 25.dp, top = 20.dp)
    ) {
        Column(
            modifier = modifier
                .weight(1f)
                .padding(bottom = 20.dp),
        ) {
            Text(
                text = transaction.applier,
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp
            )
            Text(
                text = transaction.date
            )
            Text(
                text = transaction.status,
                color = textColor
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = transaction.amount)
            IconButton(
                onClick = onClick
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_chevron_forward),
                    contentDescription = "To See Transaction Details",
                )
            }
        }
    }
    HorizontalDivider(thickness = 1.dp, color = Color.Gray)
}