package com.codingtroops.dynamiccontentexample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

val namesList: List<String> = listOf(
        "John",
        "Michael",
        "Andrew",
        "Danna",
        "Georgia")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          GreetingList(names = namesList)
        }
    }
}

@Composable
fun GreetingList(names: List<String>) {
    Column {
        for(name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GreetingList(names = namesList)
}