package com.a1ishka.bankaccount.screens.accountDashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.a1ishka.bankaccount.R
import com.a1ishka.bankaccount.data.Account


@Composable
fun AccountCard(
    account: Account,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .background(Color(49, 49, 54, 255))
    ) {
        Row(
            modifier = modifier.padding(vertical = 15.dp, horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = modifier
                    .height(70.dp)
                    .padding(end = 20.dp),
                painter = painterResource(R.mipmap.im_card_foreground),
                contentDescription = "Card Image"
            )
            AccountData(account = account)
            //do i need to associate it together or image is a constant

            ShowAccountsButton()
        }
    }
}