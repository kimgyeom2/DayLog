package com.daylog.app.core.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.daylog.app.core.data.entity.DiaryEntity

@Dao
interface  DiaryDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(diary: DiaryEntity): Long
}