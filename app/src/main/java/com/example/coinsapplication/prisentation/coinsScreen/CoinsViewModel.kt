package com.example.coinsapplication.prisentation.coinsScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinsapplication.common.Response
import com.example.coinsapplication.domain.model.Coin
import com.example.coinsapplication.domain.model.coins.CoinsState
import com.example.coinsapplication.domain.useCase.getCoinsUseCase.CoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val coinsUseCase: CoinsUseCase
) : ViewModel() {




    private var _state = mutableStateOf<CoinsState>(CoinsState())
    val state: State<CoinsState> = _state


    init {
        getCoins()
    }

    private fun getCoins() {

        coinsUseCase().onEach { result ->

            when (result) {
                is Response.Loading -> {
                    var x =CoinsState(loading = true)
                    x?.let {
                        _state.value = it
                    }

                }
                is Response.Success -> {
                    _state.value = CoinsState(coins = result.data ?: emptyList())
                }
                is Response.Error -> {
                    _state.value = CoinsState(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)


    }


}