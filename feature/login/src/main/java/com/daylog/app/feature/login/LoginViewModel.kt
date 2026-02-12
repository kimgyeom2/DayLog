package com.daylog.app.feature.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daylog.app.core.domain.usecase.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage = _toastMessage.asSharedFlow()

    private val _navigateToMain = MutableSharedFlow<Unit>()
    val navigateToMain = _navigateToMain.asSharedFlow()

    fun signUp(id: String, pw: String) {
        viewModelScope.launch {
            authUseCase.signUp(id, pw)
                .onSuccess {
                    _toastMessage.emit("회원가입 성공")
                }
                .onFailure { e ->
                    _toastMessage.emit(e.message ?: "로그인 실패")
                }
        }
    }

    fun login(id: String, pw: String) {
        viewModelScope.launch {
            authUseCase.login(id, pw)
                .onSuccess {
                    _navigateToMain.emit(Unit)
                }
                .onFailure { e ->
                    _toastMessage.emit(e.message ?: "로그인 실패")
                }
        }
    }
}
