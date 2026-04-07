package com.androidstudioprojects.lazyrowlazycolumnpagergridchips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidstudioprojects.lazyrowlazycolumnpagergridchips.ui.theme.LazyRowLazyColumnPagerGridChipsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyRowLazyColumnPagerGridChipsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen(modifier: Modifier = Modifier) {
    data class MyItem(val id: Int, val name: String)

    val itemsList = remember {
        List(100) { MyItem(id = it, name = "Item $it") }
    }

    LazyColumn(modifier = Modifier
        .background(Color.White)) {
        /*item {
            Text(text = "Dummy Text")
        }
        item {
            Text(text = "Dummy Text")
        }
        item {
            Text(text = "Dummy Text")
        }
        item {
            Text(text = "Dummy Text")
        }
        item {
            Text(text = "Dummy Text")
        }
        item {
            Text(text = "Dummy Text")
        }
        item {
            Text(text = "Dummy Text")
        }*/

        items(1000, key = {it}) {
            Text(text = "Dummy Text")
        }

        items(
            items = itemsList,
            key = { item -> item.id } // Assign unique key here
        ) { item ->
            Text(text = item.name, modifier = Modifier.padding(8.dp))
        }
    }
}