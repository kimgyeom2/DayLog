package com.daylog.app.core.domain.repository

import com.daylog.app.core.model.Diary
import kotlinx.coroutines.flow.Flow

interface DiaryRepository {
    suspend fun insert(diary: Diary)
    fun getDiaries(): Flow<List<Diary>>
}
