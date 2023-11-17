package com.maruchin.features.login.forgotpassword

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.maruchin.data.user.EmailValidationResult
import com.maruchin.data.user.isEmailValid
import com.maruchin.data.user.validateEmail

@Stable
internal class ForgotPasswordFormState {

    var email by mutableStateOf("")
        private set

    var emailError by mutableStateOf<String?>(null)
        private set

    val isValid by derivedStateOf {
        isEmailValid(email)
    }

    fun enterEmail(email: String) {
        this.email = email
        this.emailError = when (validateEmail(email)) {
            EmailValidationResult.VALID -> null
            EmailValidationResult.EMPTY -> "Email cannot be empty"
            EmailValidationResult.INVALID_FORMAT -> "Invalid email format"
        }
    }
}

@Composable
internal fun rememberForgotPasswordFormState(): ForgotPasswordFormState {
    return remember {
        ForgotPasswordFormState()
    }
}