package com.keepcoding.finalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.keepcoding.finalproject.navigation.NavigationGraph
import com.keepcoding.finalproject.ui.theme.FinalProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkMode = remember{
                mutableStateOf(false)
            }
            FinalProjectTheme(darkTheme = darkMode.value) {
                NavigationGraph(darkMode)
            }
        }
    }
}
