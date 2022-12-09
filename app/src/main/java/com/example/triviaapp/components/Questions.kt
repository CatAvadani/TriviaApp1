package com.example.triviaapp.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.triviaapp.screens.QuestionViewModel

@Composable
fun Questions(viewModel: QuestionViewModel) {
    val questions = viewModel.dataFromQuestion.value.data?.toMutableList()
    if (viewModel.dataFromQuestion.value.loading == true) {
        CircularProgressIndicator()
        Log.d("Loading", "Question: ...Loading")
    } else {
        Log.d("LoadStop", "Question: ...Loading Stopped")

        questions?.forEach { questionItem ->
            Log.d("Result", "Question: ${questionItem.question}")

        }
    }
}

@Preview
@Composable
fun QuestionDisplay(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello",
                style = TextStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 35.sp
                )
            )
        }
    }
}
