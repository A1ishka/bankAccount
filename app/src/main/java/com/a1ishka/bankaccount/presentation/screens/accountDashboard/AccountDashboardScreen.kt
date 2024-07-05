package com.a1ishka.bankaccount.presentation.screens.accountDashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.a1ishka.bankaccount.R
import com.a1ishka.bankaccount.navigation.Screen
import com.a1ishka.bankaccount.presentation.account.AccountViewModel
import com.a1ishka.bankaccount.presentation.transaction.TransactionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AccountDashboard(
    navController: NavController,
    accountViewModel: AccountViewModel,
    transactionViewModel: TransactionViewModel
) {
    val accountState = accountViewModel.accountState.value
    val transactionState = transactionViewModel.transactionState.value
    val recentTransactions = transactionState.transactionList.take(4)

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
                if (accountState.isLoading) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.secondary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    )
                }
                if (accountState.accountList.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 30.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text(
                                text = stringResource(R.string.no_account_found),
                                style = MaterialTheme.typography.displaySmall,
                                textAlign = TextAlign.Center
                            )
                            Button(
                                onClick = {
                                    navController.navigate(Screen.AccountAddingScreen.route)
                                }
                            ){
                                Text(
                                    text = stringResource(R.string.add_an_account),
                                    style = MaterialTheme.typography.displaySmall,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
                accountState.currentAccount?.let { it1 ->
                    AccountCard(
                        account = it1,
                        accountList = accountState.accountList,
                        onNavigate = {
                            navController.navigate(Screen.AccountAddingScreen.route)
                        }
                    )
                }
                RecentTransactionTitle(
                    onNavigate = {
                        navController.navigate(Screen.AllTransactionScreen.route)
                    }
                )
                RecentTransactions(transactions = recentTransactions, navController = navController)
            }
            FloatingActionButton(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .align(Alignment.BottomEnd),
                containerColor = Color(64, 156, 255),
                contentColor = Color.White,
                onClick = { navController.navigate(Screen.TransactionAddingScreen.route) },
                shape = CircleShape
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Transaction")
            }
        }
    }
}