package com.daylog.app.core.model

data class TodayState(
    val mood: Mood,
    val walkCount: Int,
    val snackCount: Int
)

enum class Mood(val emoji: String, val text: String) {
    HAPPY("😊", "행복"),
    EXCITED("🤩", "신남"),
    CALM("😌", "평온"),
    SAD("🥲", "속상"),
    ANGRY("😤", "화남"),
    SLEEPY("😴", "졸림")
}