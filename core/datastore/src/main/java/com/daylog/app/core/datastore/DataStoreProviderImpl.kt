package com.daylog.app.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreProviderImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreProvider {

    companion object {
        val NICK_NAME = stringPreferencesKey("nick_name")
        val PROFILE_URI = stringPreferencesKey("profile_uri")
    }

    override val nickNameFlow: Flow<String> =
        dataStore.data.map {
            it[NICK_NAME] ?: "뭉치"
        }

    override val profileUriFlow: Flow<String?> =
        dataStore.data.map {
            it[PROFILE_URI]
        }

    override suspend fun saveNickName(name: String) {
        dataStore.edit {
            it[NICK_NAME] = name
        }
    }

    override suspend fun saveProfileUri(uri: String) {
        dataStore.edit {
            it[PROFILE_URI] = uri
        }
    }
}
