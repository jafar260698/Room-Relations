package com.example.connectinternet.dao

import androidx.room.*
import com.example.connectinternet.model.Director
import com.example.connectinternet.model.School
import com.example.connectinternet.model.relations.DirectorAndSchool

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Transaction
    @Query("SELECT *FROM school WHERE schoolName= :schoolName")
    suspend fun getSchoolandDirectorwithSchoolName(schoolName:String)
            :List<DirectorAndSchool>



}