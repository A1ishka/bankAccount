package com.a1ishka.bankaccount.screens.allTransactions

import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.a1ishka.bankaccount.R
import com.a1ishka.bankaccount.screens.allTransactions.filterByDateBottomSheet.FilterByDateBottomSheet

@Composable
fun FilterByDateButton() {
    var showFilterBottomSheet by remember { mutableStateOf(false) }

    if (showFilterBottomSheet) {
        FilterByDateBottomSheet() {
            showFilterBottomSheet = false
        }
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(29, 29, 29, 255)
        ),
        onClick = { showFilterBottomSheet = true }) {
        Image(
            painter = painterResource(id = R.drawable.im_ellipsis_circle),
            contentDescription = "Filter Details"
        )
    }
}