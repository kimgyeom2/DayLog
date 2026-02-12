package com.daylog.app.core.domain.repository

interface AuthRepository {
    suspend fun signUp(id: String, password: String) : Result<Unit>
    suspend fun login(id: String, password: String): Result<Unit>
}
