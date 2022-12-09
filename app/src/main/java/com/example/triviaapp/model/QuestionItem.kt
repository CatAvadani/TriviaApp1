package com.example.triviaapp.model


import com.google.gson.annotations.SerializedName

data class QuestionItem(
    @SerializedName("answer")
    val answer: String? = "",
    @SerializedName("category")
    val category: String? = "",
    @SerializedName("choices")
    val choices: List<String?>? = listOf(),
    @SerializedName("question")
    val question: String? = ""
)