package com.daylog.app.core.network.request

data class LoginRequest(
    val loginId: String,
    val password: String
)