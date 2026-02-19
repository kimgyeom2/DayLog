package com.daylog.app.core.data.repositoryimpl

import android.util.Log
import com.daylog.app.core.data.database.AppDataBase
import com.daylog.app.core.data.entity.toDiaryEntity
import com.daylog.app.core.data.extension.getErrorBody
import com.daylog.app.core.domain.repository.AuthRepository
import com.daylog.app.core.domain.repository.DiaryRepository
import com.daylog.app.core.model.Diary
import com.daylog.app.core.network.api.AuthApi
import com.daylog.app.core.network.request.LoginRequest
import com.daylog.app.core.network.request.SignUpRequest
import jakarta.inject.Inject

class DiaryRepositoryImpl @Inject constructor(
    private val dataBase: AppDataBase
) : DiaryRepository {
    override suspend fun insert(diary: Diary) {
        val id = dataBase.diaryDao().insert(diary.toDiaryEntity())
        Log.e("gyeom","$id")
    }
}
