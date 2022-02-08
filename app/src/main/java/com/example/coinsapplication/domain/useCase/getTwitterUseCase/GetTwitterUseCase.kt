package com.example.coinsapplication.domain.useCase.getTwitterUseCase

import com.example.coinsapplication.common.Response
import com.example.coinsapplication.data.remote.dto.toCoinTwitter
import com.example.coinsapplication.domain.model.twitter.CoinTwitter
import com.example.coinsapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTwitterUseCase @Inject constructor(
    private val repository: CoinRepository
) {


    operator fun invoke(coinId: String): Flow<Response<List<CoinTwitter>>> = flow {

        try {
            emit(Response.Loading<List<CoinTwitter>>())
            val result = repository.getTwitter(coinId = coinId).map { it.toCoinTwitter() }
            emit(Response.Success<List<CoinTwitter>>(result))

        } catch (ex: IOException) {
            emit(Response.Error<List<CoinTwitter>>(ex.localizedMessage.toString()))
        } catch (ex: HttpException) {
            emit(Response.Error<List<CoinTwitter>>(ex.localizedMessage.toString()))
        }

    }

}