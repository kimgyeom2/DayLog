package com.daylog.app.core.model

data class Diary(
    val date: String,
    val createdAt: Long = System.currentTimeMillis(),
    val mood: Mood,
    val walkCount: Int,
    val snackCount: Int,
    val content: String,
    val imageUri: String? = null
)