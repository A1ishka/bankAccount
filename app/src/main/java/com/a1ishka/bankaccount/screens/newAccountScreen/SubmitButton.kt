package com.a1ishka.bankaccount.screens.newAccountScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a1ishka.bankaccount.R


@Composable
fun SubmitButton(
    accountName: MutableState<String>,
    accountNumber: MutableState<String>,
    accountCardNumber: MutableState<String>,
    validated: MutableState<Boolean>,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            if (validate(
                    accountName.value,
                    accountNumber.value,
                    accountCardNumber.value
                )
            ) {
                validated.value = true
                onClick
            } else {
                validated.value = false
            }
            //be replaced to VM
        },
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

fun validate(accountName: String, accountNumber: String, accountCardNumber: String): Boolean {
    if (accountName.isEmpty() || accountNumber.isEmpty() || accountCardNumber.isEmpty()) {
        return false
    }
    return true
}