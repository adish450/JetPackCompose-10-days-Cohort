package com.androidstudioprojects.composebasics

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidstudioprojects.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicsTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()) { innerPadding ->

                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .background(color = Color.Green)) {

                        //row
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            //TextView
                            Text(text = "Ozan.Card")

                            //Button
                            Button(
                                {},
                                shape = RoundedCornerShape(10.dp),
                                ) {
                                //TextView
                                Text(text = "Sign Up Free")
                            }
                        }

                        //card
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                            shape =  RoundedCornerShape(20.dp)) {

                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)) {
                                Box(modifier = Modifier) {
                                    //Image
                                    Image(painter = painterResource(R.drawable.pexels),
                                        contentDescription = "Image",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(300.dp),
                                        contentScale = ContentScale.Crop)

                                    //Image
                                    Icon(
                                        imageVector = Icons.Default.MoreVert,
                                        contentDescription = "vertical",
                                        modifier = Modifier
                                            .padding(8.dp)
                                            .size(36.dp)
                                            .align(Alignment.TopEnd))
                                }

                                Column(modifier = Modifier.fillMaxWidth()) {
                                    //Text
                                    Text(text = "Chirstopher Nicolas",
                                        modifier = Modifier
                                            .padding(10.dp),
                                        color = Color.Black,
                                        style = MaterialTheme.typography.bodyMedium)

                                    //Text
                                    Text(text = "Manager, Product Management",
                                        modifier = Modifier
                                            .padding(10.dp),
                                        color = Color.Black,
                                        style = MaterialTheme.typography.bodySmall)

                                    //Text
                                    Text(text = "Samsung",
                                        modifier = Modifier
                                            .padding(10.dp),
                                        color = Color.Black,
                                        style = MaterialTheme.typography.bodyLarge)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicsTheme {
        Greeting("Android")
    }
}
