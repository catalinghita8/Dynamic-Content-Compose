package com.codingtroops.dynamiccontentexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingList()
    }
}

@Composable
fun GreetingList() {
    val greetingListState = remember { mutableStateListOf<String>("John", "Amanda") }
    for(name in greetingListState) {
        Greeting(name = name)
    }

    Button(onClick = { greetingListState.add("Michael") }) {
        Text("Add new name")
    }
}

@Composable
fun Greeting(name: String) {
    Text(
            text = "Hello $name!",
            style = MaterialTheme.typography.h5
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}