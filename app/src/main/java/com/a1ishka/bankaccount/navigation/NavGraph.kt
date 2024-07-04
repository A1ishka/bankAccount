package com.a1ishka.bankaccount.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.a1ishka.bankaccount.presentation.account.AccountViewModel
import com.a1ishka.bankaccount.presentation.screens.accountDashboard.AccountDashboard
import com.a1ishka.bankaccount.presentation.screens.allTransactions.AllTransaction
import com.a1ishka.bankaccount.presentation.screens.newAccountScreen.NewAccountScreen
import com.a1ishka.bankaccount.presentation.screens.newTransaction.NewTransactionScreen
import com.a1ishka.bankaccount.presentation.transaction.TransactionViewModel
import com.a1ishka.bankaccount.util.Constants.ARGUMENT_ID

@Composable
fun NavGraph(
    accountViewModel: AccountViewModel = hiltViewModel(),
    transactionViewModel: TransactionViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.AllTransactionScreen.route) {
        composable(route = Screen.AccountDashboardScreen.route) {
            AccountDashboard(
                navController = navController
            )
        }

        composable(route = Screen.AccountAddingScreen.route) {
            NewAccountScreen()
        }

        composable(route = Screen.AllTransactionScreen.route) {
            AllTransaction(navController = navController)
        }

        composable(
            route = Screen.TransactionDetailsScreen.route + "?${ARGUMENT_ID}=${id}",
            arguments = listOf(
                navArgument(ARGUMENT_ID) {
                    type = NavType.LongType
                }
            )
        ) { }

        composable(route = Screen.TransactionAddingScreen.route) {
            NewTransactionScreen()
        }
    }
}

