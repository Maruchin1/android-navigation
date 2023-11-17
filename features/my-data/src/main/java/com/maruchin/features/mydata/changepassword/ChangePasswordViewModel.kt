package com.maruchin.features.mydata.changepassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ChangePasswordViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ChangePasswordUiState())
    val uiState = _uiState.asStateFlow()

    fun changePassword(currentPassword: String, newPassword: String) = viewModelScope.launch {
        userRepository.changePassword(
            currentPassword = currentPassword,
            newPassword = newPassword,
        )
        _uiState.update {
            it.copy(isSaved = true)
        }
    }
}