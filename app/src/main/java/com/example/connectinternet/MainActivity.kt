package com.example.connectinternet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private lateinit var connectivityLiveData:ConnectivityLiveData
    var text:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text=findViewById(R.id.textView)
        connectivityLiveData= ConnectivityLiveData(application)
        connectivityLiveData.observe(this, Observer {isAvailable->
            when(isAvailable){
                true->text?.text="Connected with Internet"
                false-> text?.text="No Network"
            }
        })
    }
}