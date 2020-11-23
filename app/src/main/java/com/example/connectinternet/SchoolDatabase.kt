package com.example.connectinternet

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.connectinternet.dao.SchoolDao
import com.example.connectinternet.model.Director
import com.example.connectinternet.model.School
import com.example.connectinternet.model.Student
import com.example.connectinternet.model.Subject
import com.example.connectinternet.model.relations.StudentSubjectCrossRef

@Database(
    entities =[
    School::class,
    Student::class,
    Director::class,
    Subject::class,
    StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase :RoomDatabase(){

    abstract val schoolDao:SchoolDao

    companion object{
        @Volatile
        private var INSTANCE:SchoolDatabase?=null

        fun getInstance(context: Context):SchoolDatabase{
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE=it
                }
            }
        }
    }


}