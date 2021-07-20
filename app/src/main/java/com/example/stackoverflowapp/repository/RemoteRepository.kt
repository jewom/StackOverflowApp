package com.example.stackoverflowapp.repository

import com.example.stackoverflowapp.api.ApiResult
import retrofit2.Response

object RemoteRepository {

    suspend fun <T> safeApiCall(call: suspend () -> Response<T>): ApiResult<T> {
        val myResp: Response<T> = call() // invoke() est une méthode de coroutines
        return when {
            myResp.isSuccessful -> ApiResult.Success(myResp.body()!!)
            else -> ApiResult.Error("Error : not successful")
        }
    }

}