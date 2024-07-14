package com.a1ishka.bankaccount.presentation.screens.newAccountScreen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun InputWithTitle(
    @StringRes titleId: Int,
    value: String,
    onTextChanged: (currentInput: String) -> Unit,
    keyboardType: KeyboardType,
    validated: Boolean
) {
    val borderColor = if (validated) {
        Color.Gray
    } else {
        Color.Red
    }

    Text(
        text = stringResource(titleId),
        fontSize = 18.sp
    )
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 20.dp),
        value = value,
        onValueChange = onTextChanged,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        textStyle = TextStyle(fontSize = 17.sp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = borderColor,
            focusedBorderColor = borderColor,
            focusedLabelColor = borderColor
        ),
        shape = RoundedCornerShape(10.dp)
    )
}