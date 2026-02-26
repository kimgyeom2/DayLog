package com.daylog.app.core.model

data class Diary(
    val date: String,
    val createdAt: Long = System.currentTimeMillis(),
    val mood: Mood,
    val walkCount: String,
    val snackCount: String,
    val content: String,
    val imageUri: String? = null
)