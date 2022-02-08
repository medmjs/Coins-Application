package com.example.coinsapplication.prisentation.coinDetailsScreen.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coinsapplication.prisentation.Screen
import com.example.coinsapplication.prisentation.coinDetailsScreen.CoinDetailsViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.google.android.material.internal.FlowLayout

@Composable
fun CoinDetailsScreen(
    navController: NavController,
    viewModel: CoinDetailsViewModel = hiltViewModel()
) {
    val result = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, bottom = 10.dp, start = 8.dp, end = 8.dp)
    ) {
        result.coinDetails?.let { coinDetails ->
            TopSection(coinDetails = coinDetails)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Twitter", Modifier.clickable {

                navController.navigate(Screen.CoinsTwitterScreen.route + "/"+coinDetails.id)

            })
            TagSection(coinDetails.tags)
            Spacer(modifier = Modifier.height(20.dp))
            TeamSection(coinDetails.team)

        }

    }

}

