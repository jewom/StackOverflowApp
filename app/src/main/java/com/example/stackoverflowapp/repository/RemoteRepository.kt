package com.example.stackoverflowapp.repository

import com.example.stackoverflowapp.api.ApiResult
import retrofit2.Response

object RemoteRepository {

    suspend fun <T> safeApiCall(call: suspend () -> Response<T>): ApiResult<T> {
        return try {
            val myResp: Response<T> = call.invoke() // invoke() est une méthode de coroutines
            when {
                myResp.isSuccessful -> ApiResult.Success<T>(myResp.body()!!)
                else -> ApiResult.Error("Error")
            }
        } catch (e: Exception) {
            ApiResult.Error(e.message ?: "Internet error runs")
        }
    }

}