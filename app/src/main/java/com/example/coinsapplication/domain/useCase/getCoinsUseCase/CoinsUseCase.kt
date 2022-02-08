package com.example.coinsapplication.domain.useCase.getCoinsUseCase

import com.example.coinsapplication.common.Response
import com.example.coinsapplication.data.remote.dto.toCoin
import com.example.coinsapplication.data.repository.CoinRepositoryImp
import com.example.coinsapplication.domain.model.Coin
import com.example.coinsapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(): Flow<Response<List<Coin>>> = flow {

        try {
            emit(Response.Loading<List<Coin>>())
            val result = coinRepository.getCoins().map { it.toCoin() }
            emit(Response.Success(result))
        } catch (ex: IOException) {
            emit(Response.Error<List<Coin>>(message = ex.message.toString()))
        } catch (ex: HttpException) {
            emit(Response.Error<List<Coin>>(message = ex.message.toString()))
        }
    }
}