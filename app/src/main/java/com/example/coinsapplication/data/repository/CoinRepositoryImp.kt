package com.example.coinsapplication.data.repository

import com.example.coinsapplication.common.Response
import com.example.coinsapplication.data.CoinApi
import com.example.coinsapplication.data.remote.dto.CoinDetailsDto
import com.example.coinsapplication.data.remote.dto.CoinDto
import com.example.coinsapplication.data.remote.dto.CoinTwitterDto
import com.example.coinsapplication.domain.model.Coin
import com.example.coinsapplication.domain.model.CoinDetails
import com.example.coinsapplication.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val coinApi: CoinApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return coinApi.getCoins()
    }

    override suspend fun getCoinDetails(coinId: String): CoinDetailsDto {
        return coinApi.getCoinDetails(coinId = coinId)
    }

    override suspend fun getTwitter(coinId: String): List<CoinTwitterDto> {
        return coinApi.getTwitter(coinId = coinId)
    }

}