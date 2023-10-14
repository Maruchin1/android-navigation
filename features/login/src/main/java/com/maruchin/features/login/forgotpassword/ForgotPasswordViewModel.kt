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

    val forgotPasswordFormState = ForgotPasswordFormState()

    var emailState by mutableStateOf<EmailState>(EmailState.Idle)
        private set

    fun sendLink() = viewModelScope.launch {
        emailState = EmailState.Sending
        delay(1_000)
        emailState = EmailState.Sent
    }

    fun emailSentInformationShown() {
        emailState = EmailState.Idle
    }
}