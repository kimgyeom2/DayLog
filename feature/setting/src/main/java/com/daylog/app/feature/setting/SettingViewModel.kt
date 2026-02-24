package com.daylog.app.feature.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daylog.app.core.domain.usecase.GetNickNameUseCase
import com.daylog.app.core.domain.usecase.GetProfileUriUseCase
import com.daylog.app.core.domain.usecase.SaveNickNameUseCase
import com.daylog.app.core.domain.usecase.SaveProfileUriUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    getNickNameUseCase: GetNickNameUseCase,
    getProfileUriUseCase: GetProfileUriUseCase,
    private val saveNickNameUseCase: SaveNickNameUseCase,
    private val saveProfileUriUseCase: SaveProfileUriUseCase
) : ViewModel() {

    private val _isDarkTheme = MutableStateFlow(false)
    val isDarkTheme = _isDarkTheme.asStateFlow()

    fun changeDarkTheme(isDark: Boolean) {
        _isDarkTheme.value = isDark
    }

    val nickName = getNickNameUseCase()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            "뭉치"
        )

    val profileUri = getProfileUriUseCase()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            null
        )


    fun saveNickName(name: String) {
        viewModelScope.launch {
            saveNickNameUseCase(name)
        }
    }

    fun saveProfileUri(uri: String) {
        viewModelScope.launch {
            saveProfileUriUseCase(uri)
        }
    }

}
