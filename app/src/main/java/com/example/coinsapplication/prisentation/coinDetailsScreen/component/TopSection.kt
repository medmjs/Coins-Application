package com.example.coinsapplication.prisentation.coinDetailsScreen.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coinsapplication.domain.model.CoinDetails

@Composable
fun TopSection(coinDetails: CoinDetails) {


    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "${coinDetails.rank}.${coinDetails.name}(${coinDetails.symbol})",
                fontSize = 30.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(2f)

            )
            Text(
                text = if (coinDetails.isActive) "Active" else "Not Active",
                color = if (coinDetails.isActive) Color.Green else Color.Red,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = coinDetails.description,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 5,
            lineHeight = 25.sp,
            overflow = TextOverflow.Ellipsis
        )

    }

}