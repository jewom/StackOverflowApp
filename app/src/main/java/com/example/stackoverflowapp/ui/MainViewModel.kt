package com.example.stackoverflowapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stackoverflowapp.api.ApiResult
import com.example.stackoverflowapp.models.Questions
import com.example.stackoverflowapp.repository.RemoteRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val getLastQuestionsSuccess = MutableLiveData<Questions>()
    val getLastQuestionsError = MutableLiveData<String>()

    fun getLastQuestions() {
        viewModelScope.launch {
            when (val retrofitPost = RemoteRepository().getLastQuestions()) {
                is ApiResult.Success -> getLastQuestionsSuccess.postValue(retrofitPost.data)
                is ApiResult.Error -> getLastQuestionsError.postValue(retrofitPost.errorResponse)
            }
        }
    }

}