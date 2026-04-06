package com.androidstudioprojects.compositionandrecomposition

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.androidstudioprojects.compositionandrecomposition.ui.theme.CompositionAndRecompositionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompositionAndRecompositionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen1(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Screen1(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)) {

        var counter by rememberSaveable {mutableStateOf(0)}

        Counter(counter) {
            counter++
        }
    }
}

@Composable
fun Counter(counter: Int, onValueChanged: () -> Unit) {
    Log.d("Recompose", "Enter counter")

    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = "Static Title")

        Text(text = "Count : $counter")
        Log.d("Recompose", "Counter : $counter")

        Button({onValueChanged()}) {
            Text(text = "Click")
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp))

        var email by rememberSaveable { mutableStateOf("")}

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text(text = "Email")})

        val isEnable by remember { derivedStateOf { email.isEmpty() } }

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 20.dp),
            shape = RoundedCornerShape(20.dp),
                colors = if (isEnable) ButtonDefaults.
            buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ) else ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.White
            )
        ){
            Text(text = "Submit")
        }

    }
}