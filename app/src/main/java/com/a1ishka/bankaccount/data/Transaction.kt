package com.a1ishka.bankaccount.data

data class Transaction(
    val transactionId: Long,
    val accountId: Long,
    val applier: String,
    val number: String,
    val date: String,
    val status: String,
    val amount: String
)

val transactionData = listOf(
    Transaction(0, 5, "OOO \"Company\"", "61fhtrdfs16fv", "01.06.2024", "Executed", "$10.09"),
    Transaction(1, 5, "OOO \"Company2\"", "692hdkdfs7k6v", "02.06.2024", "Declined", "$10.09"),
    Transaction(2, 5, "OOO \"Company\"", "6fxg86513hjk7", "06.06.2024", "In progress", "$10.09"),
    Transaction(3, 5, "OOO \"Company\"", "6lg845h46gd84", "01.06.2024", "Executed", "$10.09"),
    Transaction(4, 5, "OOO \"Company\"", "6lg845h46gd84", "01.06.2024", "Executed", "$10.09"),
    Transaction(5, 5, "OOO \"Company\"", "6lg845h46gd84", "01.06.2024", "Executed", "$10.09"),
    Transaction(6, 5, "OOO \"Company\"", "6lg845h46gd84", "01.06.2024", "Executed", "$10.09"),
)
