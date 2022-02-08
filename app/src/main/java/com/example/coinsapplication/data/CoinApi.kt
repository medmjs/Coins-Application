package com.example.coinsapplication.data

import com.example.coinsapplication.common.Response
import com.example.coinsapplication.data.remote.dto.CoinDetailsDto
import com.example.coinsapplication.data.remote.dto.CoinDto
import com.example.coinsapplication.data.remote.dto.CoinTwitterDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("coins/{coinId}")
    suspend fun getCoinDetails(
        @Path("coinId") coinId: String
    ): CoinDetailsDto


    @GET("coins/{coinId}/twitter")
    suspend fun getTwitter(
        @Path("coinId") coinId: String
    ): List<CoinTwitterDto>


}