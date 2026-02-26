package com.daylog.app.core.domain.usecase

import com.daylog.app.core.domain.repository.DiaryRepository
import com.daylog.app.core.model.Diary
import com.daylog.app.core.model.Mood
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import java.time.YearMonth

class DeleteDiaryUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository
) {
    suspend fun invoke(date:String) {
        diaryRepository.deleteDiary(date)
    }
}