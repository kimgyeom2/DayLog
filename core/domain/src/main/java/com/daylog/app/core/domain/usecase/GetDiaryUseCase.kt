package com.daylog.app.core.domain.usecase

import com.daylog.app.core.domain.repository.DiaryRepository
import com.daylog.app.core.model.Diary
import com.daylog.app.core.model.Mood
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import java.time.YearMonth

class GetDiaryUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository
) {
    fun invoke(): Flow<List<Diary>> {
        return diaryRepository.getDiaries()
    }

    suspend fun getCalendarData(month: YearMonth): List<Diary>{
        return diaryRepository.getCalendarData(
            month.atDay(1).toString(),
            month.atEndOfMonth().toString()
        )
    }
}