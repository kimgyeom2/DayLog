package com.daylog.app.core.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.daylog.app.core.data.entity.DiaryEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface  DiaryDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(diary: DiaryEntity): Long

    @Query("SELECT * FROM diary ORDER BY createdAt DESC")
    fun getDiaries(): Flow<List<DiaryEntity>>

    @Query("""SELECT * FROM diary WHERE date BETWEEN :start AND :end""")
    suspend fun getCalendarData(start: String,end: String): List<DiaryEntity>
}