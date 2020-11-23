package com.example.connectinternet.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Student(
    @PrimaryKey(autoGenerate = false)
    val studentName:String,
    val semester:Int,
    val schoolName:String
)