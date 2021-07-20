package com.example.stackoverflowapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.stackoverflowapp.R
import com.example.stackoverflowapp.api.ApiResult
import com.example.stackoverflowapp.databinding.FragmentMainBinding
import com.example.stackoverflowapp.models.Questions

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.lastQuestionsLiveData.observe(viewLifecycleOwner, { questions ->
            questions.items.forEach { Log.d("TEST_LOG", it.title) }
        })

        viewModel.apiErrorLiveData.observe(viewLifecycleOwner, { apiResultError ->
            Log.e("TEST_LOG", apiResultError.errorResponse)
        })

        viewModel.getQuestions()

    }


}