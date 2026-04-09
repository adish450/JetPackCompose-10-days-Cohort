@file:OptIn(ExperimentalMaterial3Api::class)

package com.androidstudioprojects.lazyrowlazycolumnpagergridchips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.androidstudioprojects.lazyrowlazycolumnpagergridchips.ui.theme.LazyRowLazyColumnPagerGridChipsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyRowLazyColumnPagerGridChipsTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "My Toolbar") },
                            navigationIcon = {
                                IconButton(onClick = { /* handle back */ }) {
                                    Icon(
                                        imageVector = Icons.Default.MoreVert,
                                        contentDescription = "Back")
                                }
                            },
                            actions = {
                                IconButton(onClick = { /* handle menu */ }) {
                                    Icon(Icons.Filled.MoreVert, contentDescription = "Menu")
                                }
                            }
                        )
                    },
                    content = { innerPadding ->
                        Screen(modifier = Modifier.padding(innerPadding))
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen(modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier
        .fillMaxWidth()) {
        item {
            TopAppBar(
                title = {
                    Text(
                        text = "Books Collection",
                        modifier = modifier
                            .fillMaxWidth()
                            .background(Color.White))
                },
                /*modifier = modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .background(Color.LightGray)*/
            )
        }
    }
}