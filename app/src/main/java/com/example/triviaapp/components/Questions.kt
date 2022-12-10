package com.example.triviaapp.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviaapp.screens.QuestionViewModel
import com.example.triviaapp.util.AppColors

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

@Composable
fun QuestionDisplay(){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(4.dp),
        color = AppColors.mDarkPurple
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(12.dp)
        ) {
            QuestionTracker()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun QuestionTracker(
    counter: Int = 10,
    outOf: Int = 100
) {
    Text(text = buildAnnotatedString {
        withStyle(style = ParagraphStyle(textIndent = TextIndent.None)) {
            withStyle(
                style = SpanStyle(
                    color = AppColors.mLightGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 27.sp
                )) {
                append("Question $counter/")
                withStyle(style = SpanStyle(
                    color = AppColors.mLightGray,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp)) {
                    append("$outOf")
                }
            }
        }
    },
        modifier = Modifier.padding(20.dp)
    )

}

@Preview(showBackground = true)
@Composable
fun QuestionDisplayPreview() {
    QuestionDisplay()
}
