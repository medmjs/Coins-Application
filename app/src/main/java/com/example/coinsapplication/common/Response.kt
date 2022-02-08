package com.example.coinsapplication.common

sealed class Response<T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T) : Response<T>(data = data, message = null)
    class Error<T>(message: String) : Response<T>(data = null, message = message)
    class Loading<T>() : Response<T>(data = null, message = null)
}
