package com.example.coinsapplication.di

import com.example.coinsapplication.common.Constraint.BASE_URL
import com.example.coinsapplication.data.CoinApi
import com.example.coinsapplication.data.repository.CoinRepositoryImp
import com.example.coinsapplication.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinApi(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(coinApi: CoinApi): CoinRepository {
        return CoinRepositoryImp(coinApi)
    }


}