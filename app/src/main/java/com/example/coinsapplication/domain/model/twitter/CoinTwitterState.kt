package com.example.coinsapplication.domain.model.twitter

data class CoinTwitterState(
    var loading: Boolean = false,
    var coinTwitters: List<CoinTwitter> = emptyList(),
    var error: String = "",

    )
