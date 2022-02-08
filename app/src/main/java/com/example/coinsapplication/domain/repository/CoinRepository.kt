package com.example.coinsapplication.domain.repository

import com.example.coinsapplication.common.Response
import com.example.coinsapplication.data.remote.dto.CoinDetailsDto
import com.example.coinsapplication.data.remote.dto.CoinDto
import com.example.coinsapplication.data.remote.dto.CoinTwitterDto
import com.example.coinsapplication.domain.model.Coin
import com.example.coinsapplication.domain.model.CoinDetails

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinDetails(coinId: String): CoinDetailsDto

    suspend fun getTwitter(coinId: String): List<CoinTwitterDto>


}