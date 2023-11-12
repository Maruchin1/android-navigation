package com.maruchin.features.profile.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.user.User
import com.maruchin.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val uiState = userRepository.get()
        .map {
            ProfileUiState(
                isLoggedIn = it is User.LoggedIn,
            )
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, ProfileUiState())
}