package com.example.connectinternet.dao

import androidx.room.*
import com.example.connectinternet.model.Director
import com.example.connectinternet.model.School
import com.example.connectinternet.model.Student
import com.example.connectinternet.model.Subject
import com.example.connectinternet.model.relations.*

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)


    @Transaction
    @Query("SELECT *FROM school WHERE schoolName= :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String)
    : List<SchoolWithStudents>

    @Transaction
    @Query("SELECT *FROM school WHERE schoolName= :schoolName")
    suspend fun getSchoolandDirectorwithSchoolName(schoolName:String)
            :List<DirectorAndSchool>

    @Transaction
    @Query("SELECT *FROM subject WHERE subjectName= :subjectName")
    suspend fun getStudentOfSubject(subjectName: String)
            : List<SubjectWithStudents>

    @Transaction
    @Query("SELECT *FROM student WHERE studentName= :studentName")
    suspend fun getSubjectOfStudent(studentName:String)
            : List<StudentWithSubject>
}