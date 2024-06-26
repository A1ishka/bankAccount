@file:OptIn(ExperimentalMaterial3Api::class)

package com.a1ishka.bankaccount.screens.allTransactions

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a1ishka.bankaccount.R
import com.a1ishka.bankaccount.data.transactionData
import com.a1ishka.bankaccount.screens.accountDashboard.RecentTransactions

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AllTransaction() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(MaterialTheme.colorScheme.primary),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "Back")
                    }
                },
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                    ) {
                        Text(
                            text = "All transactions",
                            modifier = Modifier.align(Alignment.TopCenter),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                },
                actions = {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(29, 29, 29, 255)
                        ),
                        onClick = { /*TODO*/ }) {
                        Image(painter = painterResource(id = R.drawable.im_ellipsis_circle), contentDescription = "Filter Details")
                    }
                }
            )
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                .padding(top = 50.dp)
        ) {
            RecentTransactions(transactionData)
        }
    }
}