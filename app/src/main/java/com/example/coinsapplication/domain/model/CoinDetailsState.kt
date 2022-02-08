package com.example.coinsapplication.domain.model

data class CoinDetailsState(
    var loading: Boolean = false,
    var coinDetails: CoinDetails? = null,
    var erorr: String = "",
)