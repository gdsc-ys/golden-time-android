package com.next.goldentime.ui.screens.sos.detect

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.next.goldentime.repository.sos.Location
import com.next.goldentime.repository.sos.SOSStaticRepository
import com.next.goldentime.repository.user.UserStoreRepository
import com.next.goldentime.usecase.sos.SOSUseCase

class SOSDetectViewModel(
    userStore: DataStore<Preferences>,
    private val sosUseCase: SOSUseCase = SOSUseCase(
        SOSStaticRepository(),
        UserStoreRepository(userStore)
    )
) : ViewModel() {
    suspend fun requestSOS(location: Location) = sosUseCase.requestSOS(location)
}

class SOSDetectViewModelFactory(
    private val userStore: DataStore<Preferences>
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SOSDetectViewModel::class.java)) {
            return SOSDetectViewModel(userStore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}