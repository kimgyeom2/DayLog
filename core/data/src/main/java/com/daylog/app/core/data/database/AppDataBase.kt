package com.daylog.app.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.daylog.app.core.data.dao.DiaryDao
import com.daylog.app.core.data.entity.DiaryEntity

@Database(
    entities = [
        DiaryEntity::class
    ], version = 1, exportSchema = false
)

abstract class AppDataBase : RoomDatabase() {
    abstract fun diaryDao(): DiaryDao
}