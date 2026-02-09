package com.daylog.app.core.domain.repository

interface AuthRepository {
    suspend fun signUp(id: String, password: String)
    suspend fun login(id: String, password: String)
}
