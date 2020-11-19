package com.example.connectinternet.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.connectinternet.model.Director
import com.example.connectinternet.model.School
import com.example.connectinternet.model.Student

data class SchoolWithStudents(

    @Embedded
    val school: School,

    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
        )
     val students: List<Student>
) {
}