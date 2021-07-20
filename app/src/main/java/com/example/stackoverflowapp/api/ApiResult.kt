package com.example.stackoverflowapp.api

import android.util.Log
import retrofit2.Response

sealed class ApiResult<out T: Any> {
    data class Success<out T : Any>(val data: T) : ApiResult<T>()
    data class Error(val errorResponse: String) : ApiResult<Nothing>()
}

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): ApiResult<T> {
    // TODO : showProgressDialog()
    return try {
        val myResp: Response<T> = call.invoke()
        when {
            myResp.isSuccessful -> {
                Log.i("TEST_LOG", "safeApiCall response body ${myResp.body()}")
                ApiResult.Success(myResp.body()!!)
            }
            else -> {
                ApiResult.Error("Error")
            }
        }
    } catch (e: Exception) {
        Log.e("TEST_LOG",  "safeApiCall error body exception ${e.message ?: "Internet error runs"}")
        ApiResult.Error(e.message ?: "Internet error runs")
    }
    finally {
        // TODO : hideProgressDialog()
    }
}