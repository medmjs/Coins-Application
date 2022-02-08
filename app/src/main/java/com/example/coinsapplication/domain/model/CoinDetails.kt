package com.example.coinsapplication.domain.model

import com.example.coinsapplication.data.remote.dto.*

data class CoinDetails(
    val description: String,
    val id: String,
    val isActive: Boolean,
    val links: Links,
    val message: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<Team>,
    val type: String,
)
