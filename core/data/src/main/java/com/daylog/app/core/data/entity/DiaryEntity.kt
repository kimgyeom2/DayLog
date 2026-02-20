package com.daylog.app.core.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.daylog.app.core.model.Diary
import com.daylog.app.core.model.Mood


@Entity(tableName = "diary")
data class DiaryEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    // 작성 날짜 (YYYY-MM-DD)
    val date: String,

    // (최신순 정렬용)
    val createdAt: Long = System.currentTimeMillis(),

    // 강아지 감정
    val mood: Mood,

    // 산책 횟수
    val walkCount: Int,

    // 간식 개수
    val snackCount: Int,

    // 내용
    val content: String,

    // 사진 URI (없을 수도 있음)
    val imageUri: String? = null
)

fun Diary.toDiaryEntity(): DiaryEntity {
    return DiaryEntity(
        date = date,
        createdAt = createdAt,
        mood = mood,
        walkCount = walkCount,
        snackCount = snackCount,
        content = content,
        imageUri = imageUri
    )
}

fun DiaryEntity.toDiary(): Diary {
    return Diary(
        date = date,
        createdAt = createdAt,
        mood = mood,
        walkCount = walkCount,
        snackCount = snackCount,
        content = content,
        imageUri = imageUri
    )
}