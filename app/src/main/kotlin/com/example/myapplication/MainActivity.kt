package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

//    val testLiveData: MutableLiveData<String> = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val testObserver = Observer<String> {
//
//        }
//        testLiveData.observe(this, testObserver)
    }
}