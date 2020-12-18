package com.codingtroops.dynamiccontentexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = MainViewModel()
        setContent {
            MainScreen(viewModel)
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val greetingListState = viewModel.namesListData
    val newNameTextState: State<String> = viewModel.newNameData.observeAsState("")

    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingList(greetingListState,
            { viewModel.onNewNameAdded() },
            newNameTextState.value,
            { newName -> viewModel.onTextFieldNameUpdated(newName) })
    }
}

@Composable
fun GreetingList(namesList: List<String>,
                 buttonClick: () -> Unit,
                 textFieldValue: String,
                 textFieldUpdate: (newName: String) -> Unit
) {
    for (name in namesList) {
        Greeting(name = name)
    }

    TextField(value = textFieldValue, onValueChange = textFieldUpdate)

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
    val viewModel = MainViewModel()
    MainScreen(viewModel)
}