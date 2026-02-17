package com.daylog.app.feature.setting

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class SettingViewModel @Inject constructor(
//    private val flowActionStream: FlowActionStream,
//    private val settingsRepository: SettingsRepository,
) : ViewModel() {

//    @VisibleForTesting
//    val flowAction by lazy {
//        flowActionStream.onAction<SettingAction>()
//            .onEach {
//                handleAction(action = it)
//            }
//    }
//
//    fun loadAction(): SharedFlow<SettingAction> =
//        flowAction
//            .shareIn(viewModelScope, started = SharingStarted.WhileSubscribed())
//
//    private suspend fun handleAction(action: SettingAction) {
//        when (action) {
//            is SettingAction.ChangeDarkTheme -> {
//                settingsRepository.updateIsDarkTheme(action.isDarkTheme)
//            }
//        }
//    }
//
//    fun send(action: SettingAction) {
//        flowActionStream.nextAction(action)
//    }
}
