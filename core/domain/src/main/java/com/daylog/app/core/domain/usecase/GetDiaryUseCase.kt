package com.daylog.app.core.domain.usecase

import com.daylog.app.core.domain.repository.DiaryRepository
import com.daylog.app.core.model.Diary
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetDiaryUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository
) {
    fun invoke(): Flow<List<Diary>> {
        return diaryRepository.getDiaries()
    }
}