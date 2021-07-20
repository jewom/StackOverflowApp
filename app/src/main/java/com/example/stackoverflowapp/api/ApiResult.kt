package com.example.stackoverflowapp.api

import android.util.Log
import retrofit2.Response

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val errorResponse: String) : ApiResult<Nothing>()
}

suspend fun <T> safeApiCall(call: suspend () -> Response<T>): ApiResult<T> {
    val myResp: Response<T> = call()
    return when {
        myResp.isSuccessful -> ApiResult.Success(myResp.body()!!)
        else -> ApiResult.Error("Error : not successful")
    }
}