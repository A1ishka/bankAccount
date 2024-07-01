package com.a1ishka.bankaccount.screens.newAccountScreen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumericInputWithTitle(
    @StringRes titleId: Int,
    currentNumber: MutableState<String>
){
    Text(
        text = stringResource(titleId),
        fontSize = 18.sp
    )
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 20.dp),
        value = currentNumber.value,
        onValueChange = { currentNumber.value = it },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        textStyle = TextStyle(fontSize = 17.sp),
        shape = RoundedCornerShape(10.dp)
    )
}