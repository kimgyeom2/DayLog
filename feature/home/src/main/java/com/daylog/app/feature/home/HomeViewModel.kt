package com.daylog.app.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daylog.app.core.domain.usecase.DeleteDiaryUseCase
import com.daylog.app.core.domain.usecase.GetDiaryUseCase
import com.daylog.app.core.domain.usecase.GetNickNameUseCase
import com.daylog.app.core.domain.usecase.GetProfileUriUseCase
import com.daylog.app.core.domain.usecase.InsertDiaryUseCase
import com.daylog.app.core.model.Diary
import com.daylog.app.core.model.TodayState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getNickNameUseCase: GetNickNameUseCase,
    getProfileUriUseCase: GetProfileUriUseCase,
    getDiaryUseCase : GetDiaryUseCase,
    private val insertDiaryUseCase : InsertDiaryUseCase,
    private val deleteDiaryUseCase: DeleteDiaryUseCase
) : ViewModel() {
    val nickName = getNickNameUseCase()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            "뭉치"
        )

    val profileUri = getProfileUriUseCase()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            null
        )

    val diaries: StateFlow<List<Diary>> =
        combine(
            getDiaryUseCase.invoke(),
            sortOrder
        ) { diaries, order ->

            when (order) {
                SortOrder.LATEST -> diaries.sortedByDescending { it.date }
                SortOrder.OLDEST -> diaries.sortedBy { it.date }
            }

        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val todayState: StateFlow<TodayState?> =
        diaries.map { list ->
            val today = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

            val todayDiary = list.firstOrNull { it.date == today }

            todayDiary?.let {
                TodayState(
                    mood = it.mood,
                    walkCount = it.walkCount,
                    snackCount = it.snackCount
                )
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    fun insertDiary(diary: Diary) {
        viewModelScope.launch {
            insertDiaryUseCase.invoke(diary)
        }
    }

    fun deleteDiary(diary: Diary) {
        viewModelScope.launch {
            deleteDiaryUseCase.invoke(diary.date)
        }
    }

    fun changeSort(order: SortOrder) {
        sortOrder.value = order
    }
}

enum class SortOrder {
    LATEST,
    OLDEST
}

private val sortOrder = MutableStateFlow(SortOrder.LATEST)
