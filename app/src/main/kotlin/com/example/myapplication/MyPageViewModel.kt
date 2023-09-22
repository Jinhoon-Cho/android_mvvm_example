package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyPageViewModel(): ViewModel() {
    var message:String = ""

    val currentName: MutableLiveData<String> = MutableLiveData<String>()
}