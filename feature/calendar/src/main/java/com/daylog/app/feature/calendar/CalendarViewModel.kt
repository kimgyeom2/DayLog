package com.daylog.app.feature.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daylog.app.core.domain.usecase.GetDiaryUseCase
import com.daylog.app.core.model.Diary
import com.daylog.app.core.model.MonthStats
import com.daylog.app.core.model.Mood
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.time.LocalDate
import java.time.YearMonth
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val getDiaryUseCase: GetDiaryUseCase
) : ViewModel() {

    private val _month = MutableStateFlow(YearMonth.now())
    val month = _month.asStateFlow()


    private val monthDiaries: StateFlow<List<Diary>> =
        month.flatMapLatest {
            flow {
                emit(getDiaryUseCase.getCalendarData(it))
            }
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )


    val moodMap: StateFlow<Map<LocalDate, Mood>> =
        monthDiaries.map { diaries ->

            diaries.associate {
                LocalDate.parse(it.date) to it.mood
            }

        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyMap()
        )


    val monthStats: StateFlow<MonthStats> =
        monthDiaries.map { diaries ->
            MonthStats(
                moodCount = diaries
                    .groupingBy { it.mood }
                    .eachCount(),

                walkTotal = diaries.sumOf { it.walkCount.toInt() },

                snackTotal = diaries.sumOf { it.snackCount.toInt()  }
            )

        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            MonthStats(emptyMap(), 0, 0)
        )


    fun prevMonth() {
        _month.value = _month.value.minusMonths(1)
    }

    fun nextMonth() {
        _month.value = _month.value.plusMonths(1)
    }
}