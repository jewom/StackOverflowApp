package com.example.stackoverflowapp.repository

import com.example.stackoverflowapp.api.ApiResult
import com.example.stackoverflowapp.api.retrofitClient
import com.example.stackoverflowapp.api.safeApiCall
import com.example.stackoverflowapp.models.Questions

class RemoteRepository {

    suspend fun getLastQuestions(): ApiResult<Questions> =
        safeApiCall { retrofitClient.getLastQuestions() }

}
