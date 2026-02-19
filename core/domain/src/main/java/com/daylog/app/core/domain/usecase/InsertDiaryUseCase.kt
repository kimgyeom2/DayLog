package com.daylog.app.core.domain.usecase

import com.daylog.app.core.domain.repository.DiaryRepository
import com.daylog.app.core.model.Diary
import jakarta.inject.Inject

class InsertDiaryUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository
) {
    suspend fun insertDiary(content:String,emotion:String,createdAt:String){
        diaryRepository.insert(Diary(content,emotion, createdAt))
    }
}