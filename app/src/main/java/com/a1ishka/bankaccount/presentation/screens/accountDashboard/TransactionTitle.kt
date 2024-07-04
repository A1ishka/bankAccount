package com.a1ishka.bankaccount.presentation.screens.accountDashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.a1ishka.bankaccount.R
import com.a1ishka.bankaccount.navigation.Screen

@Composable
fun RecentTransactionTitle(
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = modifier.weight(1f),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                text = stringResource(R.string.recent_transactions)
            )
            TextButton(
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color(64, 156, 255)
                ),
                onClick = onNavigate,
            ) {
                Text(stringResource(R.string.view_all))
            }
        }
    }
}