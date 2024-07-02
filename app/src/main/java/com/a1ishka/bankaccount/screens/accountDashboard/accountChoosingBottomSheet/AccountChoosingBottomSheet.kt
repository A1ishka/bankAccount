@file:OptIn(ExperimentalMaterial3Api::class)

package com.a1ishka.bankaccount.screens.accountDashboard.accountChoosingBottomSheet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.a1ishka.bankaccount.R
import com.a1ishka.bankaccount.data.accountData
import com.a1ishka.bankaccount.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    onNavigate: () -> Unit,
    onDismiss: () -> Unit
) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
            ) {
                Text(
                    text = stringResource(R.string.select_the_account),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                AccountList(accountData)
            }

            FloatingActionButton(
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .align(Alignment.BottomEnd),
                containerColor = Color(64, 156, 255),
                contentColor = Color.White,
                onClick = onNavigate,
                shape = CircleShape
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Account")
            }
        }
    }
}