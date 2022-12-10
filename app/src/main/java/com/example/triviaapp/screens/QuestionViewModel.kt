package com.example.triviaapp.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaapp.data.DataOrException
import com.example.triviaapp.model.QuestionItem
import com.example.triviaapp.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: QuestionRepository): ViewModel(){
    val dataFromQuestion: MutableState<DataOrException<ArrayList<QuestionItem>,
            Boolean, Exception>> = mutableStateOf(
        DataOrException(null, true, Exception("")))
    init {
        getAllQuestions()
    }
    private fun getAllQuestions() {
        viewModelScope.launch {
            dataFromQuestion.value.loading = true
            dataFromQuestion.value = repository.getAllQuestions()
            if (dataFromQuestion.value.data.toString().isNotEmpty()) dataFromQuestion.value.loading = false

        }
    }
    fun getTotalQuestionCount(): Int {
        return dataFromQuestion.value.data?.toMutableList()?.size!!
    }

}