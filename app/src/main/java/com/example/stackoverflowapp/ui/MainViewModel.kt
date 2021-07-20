package com.example.stackoverflowapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stackoverflowapp.api.ApiResult
import com.example.stackoverflowapp.api.retrofitClient
import com.example.stackoverflowapp.models.Questions
import com.example.stackoverflowapp.repository.RemoteRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var lastQuestionsLiveData = MutableLiveData<ApiResult<Questions>>()

    fun getQuestions() {
        viewModelScope.launch {
            lastQuestionsLiveData.postValue(
                RemoteRepository.safeApiCall{ retrofitClient.getLastQuestions() }
            )
        }
    }


}