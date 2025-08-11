package com.yashica.streakpomodoro.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [/* TODO: add entities */], version = 1)
abstract class StudyDatabase : RoomDatabase() {
    // abstract fun studyDao(): StudyDao
}
