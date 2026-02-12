package com.daylog.app.core.data.repositoryimpl

import com.daylog.app.core.data.extension.getErrorBody
import com.daylog.app.core.domain.repository.AuthRepository
import com.daylog.app.core.network.api.AuthApi
import com.daylog.app.core.network.request.LoginRequest
import com.daylog.app.core.network.request.SignUpRequest
import jakarta.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {

    override suspend fun signUp(id: String, password: String): Result<Unit> {
        return try {
            val response = authApi.signUp(SignUpRequest(id, password))
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                val errorRes = response.getErrorBody()
                val message = errorRes?.message ?: "회원가입 실패"
                Result.failure(Exception(message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun login(id: String, password: String): Result<Unit> {
        return try {
            val response = authApi.login(LoginRequest(id, password))
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                val errorRes = response.getErrorBody()
                val message = errorRes?.message ?: "로그인 실패."
                Result.failure(Exception(message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
