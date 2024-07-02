package com.a1ishka.bankaccount.navigation

sealed class Screen(val route: String) {
    object AccountDashboardScreen : Screen(route = "account_dashboard_screen")
    object AccountAddingScreen : Screen(route = "account_adding_screen")
    object AllTransactionScreen : Screen(route = "all_transaction_screen")
    object TransactionDetailsScreen : Screen(route = "transaction_details_screen")
    object TransactionAddingScreen : Screen(route = "transaction_adding_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {arg->
                append("/$arg")
            }
        }
    }
}