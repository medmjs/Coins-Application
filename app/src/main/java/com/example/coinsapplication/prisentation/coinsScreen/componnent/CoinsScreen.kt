package com.example.coinsapplication.prisentation.coinsScreen.componnent

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coinsapplication.prisentation.Screen
import com.example.coinsapplication.prisentation.coinsScreen.CoinsViewModel

@Composable
fun CoinsScreen(
    navController: NavController,
    viewModel: CoinsViewModel = hiltViewModel()
) {

    val result = viewModel.state.value
    val coins = result.coins


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, bottom = 10.dp, start = 8.dp, end = 8.dp)
    ) {
        LazyColumn {
            items(coins) { coin ->
                CoinItem(coin = coin) {
                    navController.navigate(Screen.CoinsDetailsScreen.route + "/" + it.id)
                }
                Divider()
            }
        }
    }
}