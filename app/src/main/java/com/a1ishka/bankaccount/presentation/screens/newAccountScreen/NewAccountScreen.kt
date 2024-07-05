package com.a1ishka.bankaccount.presentation.screens.newAccountScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a1ishka.bankaccount.R
import com.a1ishka.bankaccount.presentation.account.AccountEvent
import com.a1ishka.bankaccount.presentation.account.AccountViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewAccountScreen(accountViewModel: AccountViewModel) {

    val accountState by accountViewModel.accountState.collectAsState()

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
                value = accountState.name,
                onTextChanged = { newName ->
                    accountViewModel.onAccountEvent(
                        AccountEvent.SetAccountName(
                            newName
                        )
                    )
                },
                keyboardType = KeyboardType.Text,
                validated = accountState.isAccountVerified
            )
            InputWithTitle(
                titleId = R.string.account_number,
                value = accountState.accountNumber.toString(),
                onTextChanged = { newNumber ->
                    accountViewModel.onAccountEvent(
                        AccountEvent.SetAccountNumber(
                            newNumber.toLong()
                        )
                    )
                },
                keyboardType = KeyboardType.Number,
                validated = accountState.isAccountVerified
            )
            InputWithTitle(
                titleId = R.string.card_number,
                value = accountState.cardNumber.toString(),
                onTextChanged = { newNumber ->
                    accountViewModel.onAccountEvent(
                        AccountEvent.SetCardNumber(
                            newNumber.toLong()
                        )
                    )
                },
                keyboardType = KeyboardType.Number,
                validated = accountState.isAccountVerified
            )

            SubmitButton()
        }
    }
}