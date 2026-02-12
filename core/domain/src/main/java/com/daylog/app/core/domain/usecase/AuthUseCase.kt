package com.daylog.app.core.domain.usecase

import com.daylog.app.core.domain.repository.AuthRepository
import jakarta.inject.Inject

class AuthUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend fun signUp(id: String, pw: String): Result<Unit> {
        return authRepository.signUp(id, pw)
    }

    suspend fun login(id: String, pw: String): Result<Unit> {
        return authRepository.login(id, pw)
    }
}