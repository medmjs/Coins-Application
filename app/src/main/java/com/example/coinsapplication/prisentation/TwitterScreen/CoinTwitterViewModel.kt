package com.example.coinsapplication.prisentation.TwitterScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.*
import com.example.coinsapplication.common.Response
import com.example.coinsapplication.domain.model.twitter.CoinTwitterState
import com.example.coinsapplication.domain.useCase.getTwitterUseCase.GetTwitterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinTwitterViewModel @Inject constructor(
    private val getTwitterUseCase: GetTwitterUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val arg = savedStateHandle.get<String>("coinId")

    private var _state = mutableStateOf(CoinTwitterState())
    val state: State<CoinTwitterState> = _state

    init {
        arg?.let { coinId ->
            getCoinTwitter(coinId)
        }
    }

    fun getCoinTwitter(coinId: String) {

        getTwitterUseCase(coinId = coinId).onEach { response ->

            when (response) {
                is Response.Loading -> {
                    _state.value = CoinTwitterState(loading = true)
                }
                is Response.Success -> {
                    _state.value = CoinTwitterState(coinTwitters = response.data!!)
                }
                is Response.Error -> {
                    _state.value = CoinTwitterState(error = response.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }


}