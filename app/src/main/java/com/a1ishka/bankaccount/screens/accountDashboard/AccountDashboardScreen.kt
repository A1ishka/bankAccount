@file:OptIn(ExperimentalMaterial3Api::class)

package com.a1ishka.bankaccount.screens.accountDashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a1ishka.bankaccount.R
import com.a1ishka.bankaccount.data.accountData
import com.a1ishka.bankaccount.data.transactionData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AccountDashboard() {
    val recentTransactions = transactionData.take(4)

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(MaterialTheme.colorScheme.primary),
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                    ) {
                        Text(
                            text = stringResource(R.string.account),
                            modifier = Modifier.align(Alignment.TopStart),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                }
            )
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                .padding(top = 50.dp)
        ) {
            Column {
                AccountCard(account = accountData[2])
                RecentTransactionTitle()
                RecentTransactions(recentTransactions)
            }
            FloatingActionButton(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .align(Alignment.BottomEnd),
                containerColor = Color(64, 156, 255),
                contentColor = Color.White,
                onClick = { /*TODO*/ },
                shape = CircleShape
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Transaction")
            }
        }
    }
}