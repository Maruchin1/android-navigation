package com.maruchin.features.login.changepassword

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ChangePasswordViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val userRepository: UserRepository,
) : ViewModel() {

    private val args = ChangePasswordArgs(savedStateHandle)

    val changePasswordFormState = ChangePasswordFormState()

    var passwordChangeState by mutableStateOf<PasswordChangeState>(PasswordChangeState.Idle)
        private set

    fun changePassword() = viewModelScope.launch {
        passwordChangeState = PasswordChangeState.Processing
        val newPassword = changePasswordFormState.newPassword
        userRepository.changePassword(newPassword, args.token)
        userRepository.login(args.email, newPassword)
        passwordChangeState = PasswordChangeState.LoggedIn
    }
}