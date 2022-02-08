package com.example.coinsapplication.prisentation.coinsScreen.componnent

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.coinsapplication.domain.model.Coin
import com.example.coinsapplication.prisentation.ui.theme.Shapes

@Composable
fun CoinItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .clickable {
                onItemClick(coin)
            }
    ) {
        Text(
            text = "${coin.rank}.${coin.name}(${coin.symbol})",
            style = MaterialTheme.typography.body1
        )

        Text(
            text = if (coin.isActive) "Active" else "Not active",
            color = if (coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic
        )

    }

}