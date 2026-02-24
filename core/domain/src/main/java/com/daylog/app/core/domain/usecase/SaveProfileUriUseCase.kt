package com.daylog.app.core.domain.usecase

import com.daylog.app.core.datastore.DataStoreProvider
import jakarta.inject.Inject

class SaveProfileUriUseCase @Inject constructor(
    private val repository: DataStoreProvider
) {
    suspend operator fun invoke(uri: String) {
        repository.saveProfileUri(uri)
    }
}