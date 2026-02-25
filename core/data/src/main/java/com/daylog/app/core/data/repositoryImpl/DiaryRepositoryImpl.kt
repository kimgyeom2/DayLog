package com.daylog.app.core.data.repositoryimpl

import android.util.Log
import com.daylog.app.core.data.database.AppDataBase
import com.daylog.app.core.data.entity.toDiary
import com.daylog.app.core.data.entity.toDiaryEntity
import com.daylog.app.core.data.extension.getErrorBody
import com.daylog.app.core.domain.repository.AuthRepository
import com.daylog.app.core.domain.repository.DiaryRepository
import com.daylog.app.core.model.Diary
import com.daylog.app.core.network.api.AuthApi
import com.daylog.app.core.network.request.LoginRequest
import com.daylog.app.core.network.request.SignUpRequest
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class DiaryRepositoryImpl @Inject constructor(
    private val dataBase: AppDataBase
) : DiaryRepository {

    override suspend fun insert(diary: Diary) {
        dataBase.diaryDao().insert(diary.toDiaryEntity())
    }

    override fun getDiaries(): Flow<List<Diary>> {
        return dataBase.diaryDao().getDiaries().map { entityList ->
            entityList.map { it.toDiary() }
        }
    }

    override suspend fun getCalendarData(start: String, end: String): List<Diary> {
        return dataBase.diaryDao().getCalendarData(start,end).map { it.toDiary() }
    }
}
