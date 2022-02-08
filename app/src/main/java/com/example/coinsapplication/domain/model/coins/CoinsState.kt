package com.example.coinsapplication.domain.model.coins

import com.example.coinsapplication.domain.model.Coin

data class CoinsState(
    var loading: Boolean  = false,
    var coins: List<Coin>  = emptyList(),
    var error: String  = ""
)
