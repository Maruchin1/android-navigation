package com.maruchin.features.mydata.changepassword

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ChangePasswordViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    var isSaved: Boolean by mutableStateOf(false)
        private set

    fun changePassword(currentPassword: String, newPassword: String) = viewModelScope.launch {
        userRepository.changePassword(
            currentPassword = currentPassword,
            newPassword = newPassword,
        )
        isSaved = true
    }
}