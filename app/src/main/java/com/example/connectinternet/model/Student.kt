package com.example.connectinternet.model

import androidx.room.PrimaryKey

data class Student(
    @PrimaryKey(autoGenerate = false)
    val studentName:String,
    val semester:Int,
    val schoolName:String

)