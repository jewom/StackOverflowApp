package com.example.stackoverflowapp.repository

import com.example.stackoverflowapp.api.ApiResult
import com.example.stackoverflowapp.api.retrofitClient
import com.example.stackoverflowapp.api.safeApiCall
import retrofit2.Response

object RemoteRepository {

    suspend fun getLastQuestions() = safeApiCall{ retrofitClient.getLastQuestions() }

}