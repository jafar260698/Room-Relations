package com.example.connectinternet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.connectinternet.model.Director
import com.example.connectinternet.model.School
import com.example.connectinternet.model.Student
import com.example.connectinternet.model.Subject
import com.example.connectinternet.model.relations.StudentSubjectCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var connectivityLiveData:ConnectivityLiveData
    var text:TextView?=null

    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text=findViewById(R.id.textView)
        connectivityLiveData= ConnectivityLiveData(application)
        connectivityLiveData.observe(this, Observer {isAvailable->
            when(isAvailable){
                true-> Log.d("TAG","Connected with Internet")
                false-> Log.d("TAG","No Internet")
            }
        })
        val dao=SchoolDatabase.getInstance(this).schoolDao

        val director= listOf(
            Director("Jafar Temirov","Guldu"),
            Director("Alisher Normatov","Tatu")
        )
        val school= listOf(
            School("Guldu"),
            School("Tatu"),
            School("Tuit")
        )
        val subject= listOf(
            Subject("Matematika"),
            Subject("informatika")
        )
        val students= listOf(
            Student("Ali",2,"Guldu"),
            Student("Vali",3,"Tuit")
        )
        val studentSubjectRelation= listOf(
            StudentSubjectCrossRef("Ali","playing chess"),
            StudentSubjectCrossRef("Vali","playing footbal")
            )

        lifecycleScope.launch {
            director.forEach { dao.insertDirector(it)}
            school.forEach { dao.insertSchool(it)}
            subject.forEach { dao.insertSubject(it)}
            students.forEach { dao.insertStudent(it)}
            studentSubjectRelation.forEach { dao.insertStudentSubjectCrossRef(it) }


            val schoolWithDirector=dao.getSchoolandDirectorwithSchoolName("Guldu")

            val schoolWithStudent=dao.getSchoolWithStudents("Guldu")
        }
    }
}