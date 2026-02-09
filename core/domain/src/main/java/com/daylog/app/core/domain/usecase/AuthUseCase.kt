package com.daylog.app.core.domain.usecase

import com.daylog.app.core.domain.repository.AuthRepository
import jakarta.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend fun signUp(id:String,pw:String){
        repository.signUp(id,pw)
    }

    suspend fun login(id:String,pw:String){
        repository.login(id,pw)
    }
}