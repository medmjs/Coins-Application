package com.example.coinsapplication.prisentation.coinDetailsScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinsapplication.common.Response
import com.example.coinsapplication.domain.model.CoinDetailsState
import com.example.coinsapplication.domain.useCase.getCoinDetailsUseCase.CoinDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val coinDetailsUseCase: CoinDetailsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    val arg = savedStateHandle.get<String>("coinId")

    init {
        arg?.let {
            getCoinDetails(it)
        }
    }


    fun getCoinDetails(coinId: String) {

        coinDetailsUseCase(coinId = coinId).onEach { result ->

            when (result) {
                is Response.Loading -> {
                    _state.value = CoinDetailsState(loading = true)
                }
                is Response.Success -> {
                    _state.value = CoinDetailsState(coinDetails = result.data)
                }
                is Response.Error -> {
                    _state.value = CoinDetailsState(erorr = result.message.toString())
                }
            }

        }.launchIn(viewModelScope)

    }


}