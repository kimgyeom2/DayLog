package com.daylog.app.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daylog.app.core.domain.usecase.InsertDiaryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val insertDiaryUseCase : InsertDiaryUseCase
) : ViewModel() {

    fun insertDiary(content:String,emotion:String,createdAt:String) {
        viewModelScope.launch {
            insertDiaryUseCase.insertDiary(content,emotion,createdAt)
        }
    }

}
