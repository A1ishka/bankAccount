package com.a1ishka.bankaccount.data.local_data

data class Account(
    val accountId: Long,
    val name: String,
    val accountNumber: Long,
    val cardNumber: Long
)

val accountData = listOf(
    Account(3, "My first account", 91212192291221, 5558794679461234),
    Account(4, "For travelling", 91212192291221, 5558794679461234),
    Account(5, "Saving Account", 91212192291221, 5558794679461234)
)