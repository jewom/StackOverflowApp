package com.example.stackoverflowapp.api

import com.example.stackoverflowapp.models.Questions
import retrofit2.Response
import retrofit2.http.GET

interface StackOverflowService {

    @GET("questions?order=desc&sort=activity&site=stackoverflow")
    suspend fun getLastQuestions() : Response<Questions>

}