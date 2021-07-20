package com.example.stackoverflowapp.repository

import com.example.stackoverflowapp.api.ApiResult
import retrofit2.Response

object RemoteRepository {

    suspend fun <T> safeApiCall(call: suspend () -> Response<T>): ApiResult<T> {
        val myResp: Response<T> = call() // on invoque notre lambda/coroutine entrée en paramètre qui nous retourne un objet Response
        return when {
            myResp.isSuccessful -> ApiResult.Success(myResp.body()!!) // si la réponse est successful, on retourne un objet ApiResult.Success
            else -> ApiResult.Error("Error : not successful") // sinon on retourne un objet ApiResult.Error
        }
    }

}