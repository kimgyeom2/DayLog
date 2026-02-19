package com.daylog.app.core.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.daylog.app.core.model.Diary


@Entity(tableName = "diary")
data class DiaryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val content: String,
    val emotion: String,
    val createdAt: String
)

fun Diary.toDiaryEntity(): DiaryEntity {
    return DiaryEntity(
        content = content,
        emotion = emotion,
        createdAt = createdAt
    )
}

fun DiaryEntity.toDiary(): Diary {
    return Diary(
        content = content,
        emotion = emotion,
        createdAt = createdAt
    )
}