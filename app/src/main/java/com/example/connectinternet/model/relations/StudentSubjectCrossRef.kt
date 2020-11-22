package com.example.connectinternet.model.relations

import androidx.room.Entity
import java.util.*

@Entity(primaryKeys = ["studentName","subjectName"])
data class StudentSubjectCrossRef(
    val studentName:String,
    val subjectName:String
) {
}