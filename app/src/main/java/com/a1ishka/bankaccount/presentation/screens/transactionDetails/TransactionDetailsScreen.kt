@file:OptIn(ExperimentalMaterial3Api::class)

package com.a1ishka.bankaccount.presentation.screens.transactionDetails

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a1ishka.bankaccount.R
import com.a1ishka.bankaccount.data.local_data.Transaction

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TransactionDetailsScreen(
    transaction: Transaction
) {
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
                            text = stringResource(R.string.transaction),
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
                .padding(top = 80.dp)
        ) {
            Column {
                Text(
                    text = stringResource(R.string.transaction_was_applied_in),
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 20.dp),
                    value = transaction.applier,
                    onValueChange = {},
                    readOnly = true,
                    textStyle = TextStyle(fontSize = 17.sp),
                    shape = RoundedCornerShape(10.dp)
                )
                Text(
                    text = stringResource(R.string.transaction_number),
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 20.dp),
                    value = transaction.number,
                    onValueChange = {},
                    readOnly = true,
                    textStyle = TextStyle(fontSize = 17.sp),
                    shape = RoundedCornerShape(10.dp)
                )
                Text(
                    text = stringResource(R.string.date),
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 20.dp),
                    value = transaction.date,

                    onValueChange = {},
                    readOnly = true,
                    textStyle = TextStyle(fontSize = 17.sp),
                    shape = RoundedCornerShape(10.dp)
                )
                Text(
                    text = stringResource(R.string.transaction_status),
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 20.dp),
                    value = transaction.status,
                    onValueChange = {},
                    readOnly = true,
                    textStyle = TextStyle(fontSize = 17.sp),
                    shape = RoundedCornerShape(10.dp)
                )
                Text(
                    text = stringResource(R.string.amount),
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 20.dp),
                    value = transaction.amount,
                    onValueChange = {},
                    readOnly = true,
                    textStyle = TextStyle(fontSize = 17.sp),
                    shape = RoundedCornerShape(10.dp)
                )
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { /*TODO*/ },
                    //TODO: validation
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(64, 156, 255, 255),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.okay),
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}
