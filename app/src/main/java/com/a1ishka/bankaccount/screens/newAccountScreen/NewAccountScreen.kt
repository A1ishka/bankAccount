package com.a1ishka.bankaccount.screens.newAccountScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a1ishka.bankaccount.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewAccountScreen() {
    val accountName = remember { mutableStateOf("") }
    val accountNumber = remember { mutableStateOf("") }
    val accountCardNumber = remember { mutableStateOf("") }
    val validated = remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .padding(top = 30.dp)
    ) {
        Column {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
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
            InputWithTitle(
                titleId = R.string.account_name,
                currentInput = accountName,
                keyboardType = KeyboardType.Text,
                validated = validated.value
            )
            InputWithTitle(
                titleId = R.string.account_number,
                currentInput = accountNumber,
                keyboardType = KeyboardType.Number,
                validated = validated.value
            )
            InputWithTitle(
                titleId = R.string.card_number,
                currentInput = accountCardNumber,
                keyboardType = KeyboardType.Number,
                validated = validated.value
            )

            SubmitButton(accountName, accountNumber, accountCardNumber, validated)
        }
    }
}