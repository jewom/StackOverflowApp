package com.example.stackoverflowapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stackoverflowapp.api.ApiResult
import com.example.stackoverflowapp.api.retrofitClient
import com.example.stackoverflowapp.api.safeApiCall
import com.example.stackoverflowapp.models.Questions
import com.example.stackoverflowapp.repository.RemoteRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var lastQuestionsLiveData = MutableLiveData<Questions?>()
    var apiErrorLiveData = MutableLiveData<ApiResult.Error>()

    fun getLastQuestions() {
        viewModelScope.launch {
            when(val result = RemoteRepository.getLastQuestions()){
                is ApiResult.Success -> lastQuestionsLiveData.postValue(result.data)
                is ApiResult.Error -> apiErrorLiveData.postValue(result)
            }
        }
    }

}

