package com.maruchin.features.login.changepassword

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.user.User
import com.maruchin.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ChangePasswordViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val userRepository: UserRepository,
) : ViewModel() {

    private val args = ChangePasswordArgs(savedStateHandle)

    val isLoggedIn = userRepository.get()
        .map { it is User.LoggedIn }
        .stateIn(viewModelScope, SharingStarted.Lazily, false)

    fun changePassword(newPassword: String) = viewModelScope.launch {
        userRepository.changePassword(newPassword, args.token)
        userRepository.login(args.email, newPassword)
    }
}