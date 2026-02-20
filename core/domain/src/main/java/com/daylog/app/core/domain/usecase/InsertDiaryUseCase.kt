package com.daylog.app.core.domain.usecase

import com.daylog.app.core.domain.repository.DiaryRepository
import com.daylog.app.core.model.Diary
import com.daylog.app.core.model.Mood
import jakarta.inject.Inject

class InsertDiaryUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository
) {
    suspend fun invoke(){
        diaryRepository.insert(Diary(date="2026-02-20", mood = Mood.HAPPY, walkCount = 1, snackCount = 2, content = "테스트입니다"))
    }
}