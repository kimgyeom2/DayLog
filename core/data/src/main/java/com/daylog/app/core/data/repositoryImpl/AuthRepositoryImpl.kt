package com.daylog.app.core.data.repositoryimpl

import com.daylog.app.core.domain.repository.AuthRepository
import com.daylog.app.core.network.api.AuthApi
import com.daylog.app.core.network.request.LoginRequest
import com.daylog.app.core.network.request.SignUpRequest
import jakarta.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {

    override suspend fun signUp(id: String, password: String) {
        authApi.signUp(
            SignUpRequest(id, password)
        )
    }

    override suspend fun login(id: String, password: String) {
        authApi.login(
            LoginRequest(id, password)
        )
    }
}
