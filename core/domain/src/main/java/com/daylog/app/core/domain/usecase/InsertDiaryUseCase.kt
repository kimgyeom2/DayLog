package com.daylog.app.core.domain.usecase

import com.daylog.app.core.domain.repository.DiaryRepository
import com.daylog.app.core.model.Diary
import jakarta.inject.Inject

class InsertDiaryUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository
) {
    suspend fun invoke(diary: Diary) {
        diaryRepository.insert(
            Diary(
                date = diary.date,
                mood = diary.mood,
                walkCount = diary.walkCount,
                snackCount = diary.snackCount,
                content = diary.content,
                imageUri = diary.imageUri
            )
        )
    }
}