package com.daylog.app.core.domain.repository

import com.daylog.app.core.model.Diary

interface DiaryRepository {
    suspend fun insert(diary: Diary)
}
