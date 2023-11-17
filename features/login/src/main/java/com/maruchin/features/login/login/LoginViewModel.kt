package com.maruchin.features.login.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
internal class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val loginFormState = LoginFormState()

    val isLoggedIn = userRepository.get()
        .map { it is User.LoggedIn }
        .stateIn(viewModelScope, SharingStarted.Lazily, false)

    var isLoading by mutableStateOf(false)
        private set

    fun login() = viewModelScope.launch {
        if (!loginFormState.isValid) return@launch
        isLoading = true
        val email = loginFormState.email
        val password = loginFormState.password
        userRepository.login(email, password)
        isLoading = false
    }
}