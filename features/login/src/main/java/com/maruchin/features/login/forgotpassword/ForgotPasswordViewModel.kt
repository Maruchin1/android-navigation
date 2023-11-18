package com.maruchin.features.login.forgotpassword

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ForgotPasswordViewModel @Inject constructor() : ViewModel() {

    var emailSent: Boolean by mutableStateOf(false)
        private set

    fun sendLink(email: String) = viewModelScope.launch {
        delay(1_000)
        emailSent = true
    }

    fun emailSentInformationShown() {
        emailSent = false
    }
}