package com.daylog.app.core.domain.usecase

import com.daylog.app.core.datastore.DataStoreProvider
import jakarta.inject.Inject

class SaveNickNameUseCase @Inject constructor(
    private val repository: DataStoreProvider
) {
    suspend operator fun invoke(uri: String) {
        repository.saveNickName(uri)
    }
}