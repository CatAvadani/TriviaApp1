package com.example.triviaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.triviaapp.screens.TriviaHome
import com.example.triviaapp.ui.theme.TriviaAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaAppTheme {
               TriviaHome()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TriviaAppTheme {
        TriviaHome()
    }
}