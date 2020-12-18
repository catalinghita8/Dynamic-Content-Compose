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
    val greetingListState = remember {
        mutableStateListOf<String>("John", "Amanda")
    }

    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingList(greetingListState) {
            greetingListState.add("Michael")
        }
    }
}

@Composable
fun GreetingList(namesList: List<String>, buttonClick: () -> Unit) {
    for(name in namesList) {
        Greeting(name = name)
    }

    Button(onClick = buttonClick) {
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