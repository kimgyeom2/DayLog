package com.daylog.app.core.model

import java.time.LocalDate

data class Calendar(
    val date: LocalDate,
    val mood: Mood? = null
)