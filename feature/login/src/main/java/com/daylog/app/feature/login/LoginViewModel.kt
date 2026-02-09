package com.daylog.app.feature.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daylog.app.core.domain.usecase.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    fun signUp(id: String, pw: String) {
        viewModelScope.launch {
            try {
                authUseCase.signUp(id, pw)
            } catch (e: Throwable) {
                Log.e("gyeom",e.toString())
            }
        }
    }

    fun login(id: String, pw: String) {
        viewModelScope.launch {
            try {
                authUseCase.login(id, pw)
            } catch (e: Throwable) {
                Log.e("gyeom",e.toString())
            }
        }
    }
}
