package com.daylog.app.core.model

data class TodayState(
    val mood: Mood,
    val walkCount: Int,
    val snackCount: Int
)

enum class Mood(val emoji: String, val text: String) {
    HAPPY("😊", "기분 좋아요"),
    NORMAL("😐", "평범해요"),
    SAD("😢", "조금 우울해요")
}