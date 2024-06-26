package com.a1ishka.bankaccount.data

data class Transaction(
    val applier: String,
    val number: String,
    val date: String, //for calendar integration mappers will be added
    val status: String,
    val amount: String //or fixed "$" + double with formatting
)

val transactionData = listOf(
    Transaction("OOO \"Company\"", "61fhtrdfs16fv", "01.06.2024", "Executed", "$10.09"),
    Transaction("OOO \"Company2\"", "692hdkdfs7k6v", "02.06.2024", "Declined", "$10.09"),
    Transaction("OOO \"Company\"", "6fxg86513hjk7", "06.06.2024", "In progress", "$10.09"),
    Transaction("OOO \"Company\"", "6lg845h46gd84", "01.06.2024", "Executed", "$10.09"),
)
