package com.daylog.app.core.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "diary")
data class DiaryEntity(
    @PrimaryKey val id: String,
    val content: String,
    val emotion: String,
    val createdAt: Long
)

