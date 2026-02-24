package com.daylog.app.core.datastore

import kotlinx.coroutines.flow.Flow

interface DataStoreProvider {
    val nickNameFlow: Flow<String>

    val profileUriFlow: Flow<String?>

    suspend fun saveNickName(name: String)

    suspend fun saveProfileUri(uri: String)
}