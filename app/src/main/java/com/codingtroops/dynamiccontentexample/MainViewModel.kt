package com.codingtroops.dynamiccontentexample

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val namesListData = mutableStateListOf<String>()
    val newNameData: MutableLiveData<String> = MutableLiveData("")

    fun onNewNameAdded() {
        val newName = newNameData.value
        namesListData.add(newName?: "")
    }

    fun onTextFieldNameUpdated(newName: String) {
        newNameData.value = newName
    }
}