package com.example.coinsapplication.domain.useCase.getCoinDetailsUseCase

import com.example.coinsapplication.common.Response
import com.example.coinsapplication.data.remote.dto.toCoinDetails
import com.example.coinsapplication.domain.model.CoinDetails
import com.example.coinsapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinDetailsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {


    operator fun invoke(coinId: String): Flow<Response<CoinDetails>> = flow {

        try {
            emit(Response.Loading<CoinDetails>())
            val result = coinRepository.getCoinDetails(coinId = coinId).toCoinDetails()
            emit(Response.Success(result))
        } catch (ex: IOException) {
            emit(Response.Error<CoinDetails>(ex.localizedMessage.toString()))
        } catch (ex: HttpException) {
            emit(Response.Error<CoinDetails>(ex.localizedMessage.toString()))
        }


    }


}