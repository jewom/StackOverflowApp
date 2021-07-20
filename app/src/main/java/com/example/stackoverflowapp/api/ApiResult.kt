package com.example.stackoverflowapp.api

import android.util.Log
import retrofit2.Response

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val errorResponse: String) : ApiResult<Nothing>()
}
