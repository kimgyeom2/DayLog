package com.daylog.app.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daylog.app.core.domain.usecase.GetDiaryUseCase
import com.daylog.app.core.domain.usecase.InsertDiaryUseCase
import com.daylog.app.core.model.Diary
import com.daylog.app.core.model.TodayState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val insertDiaryUseCase : InsertDiaryUseCase,
    private val getDiaryUseCase : GetDiaryUseCase
) : ViewModel() {

    fun insertDiary() {
        viewModelScope.launch {
            insertDiaryUseCase.invoke()
        }
    }


    val diaries: StateFlow<List<Diary>> =
        getDiaryUseCase.invoke()
            .stateIn(
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
}
