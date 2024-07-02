package com.a1ishka.bankaccount.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.a1ishka.bankaccount.screens.accountDashboard.AccountDashboard
import com.a1ishka.bankaccount.screens.allTransactions.AllTransaction
import com.a1ishka.bankaccount.screens.newAccountScreen.NewAccountScreen
import com.a1ishka.bankaccount.screens.newTransaction.NewTransactionScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.AccountDashboardScreen.route) {
        composable(route = Screen.AccountDashboardScreen.route) {
            AccountDashboard(navController = navController)
        }

        composable(route = Screen.AccountAddingScreen.route) {
            NewAccountScreen()
        }

        composable(route = Screen.AllTransactionScreen.route) {
            AllTransaction()
        }

        composable(
            route = Screen.TransactionDetailsScreen.route + "?id=${id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                }
            )
        ) { entry ->
//            TransactionDetailsScreen(id = entry.arguments?.getLong("id"))
        }

        composable(route = Screen.TransactionAddingScreen.route) {
            NewTransactionScreen()
        }

    }
}