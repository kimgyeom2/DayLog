package com.daylog.app.core.domain.usecase

import com.daylog.app.core.datastore.DataStoreProvider
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetNickNameUseCase @Inject constructor(
    private val repository: DataStoreProvider
) {
    operator fun invoke(): Flow<String> {
        return repository.nickNameFlow
    }
}