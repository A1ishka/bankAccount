package com.a1ishka.bankaccount.data

data class Account(
    val name: String,
    val accountNumber: Long,
    val cardNumber: Long
)

val accountData = listOf(
    Account("My first account", 91212192291221, 5558794679461234),
    Account("For travelling", 91212192291221, 5558794679461234),
    Account("Saving Account", 91212192291221, 5558794679461234)
)