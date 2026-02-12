package com.daylog.app.core.data.extension

import com.daylog.app.core.network.response.ErrorResponse
import com.google.gson.Gson
import retrofit2.Response

fun <T> Response<T>.getErrorBody(): ErrorResponse? {
    return try {
        val json = errorBody()?.string()
        Gson().fromJson(json, ErrorResponse::class.java)
    } catch (e: Exception) {
        null
    }
}