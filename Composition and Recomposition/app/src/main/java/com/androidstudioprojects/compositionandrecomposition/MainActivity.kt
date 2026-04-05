package com.androidstudioprojects.compositionandrecomposition

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidstudioprojects.compositionandrecomposition.ui.theme.CompositionAndRecompositionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompositionAndRecompositionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier) {
    Log.d("Recompose", "Enter counter")

    var counter = mutableStateOf(0)

    Column(modifier = modifier.padding(10.dp)) {
        Text(text = "Static Title")

        Text(text = "Count : ${counter.value}")
        Log.d("Recompose", "Counter : ${counter.value}")

        Button({counter.value++}) {
            Text(text = "Click")
        }
    }
}