package com.maruchin.features.login.forgotpassword

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.maruchin.data.user.Email

@Stable
internal class ForgotPasswordFormState {

    var email by mutableStateOf("")
        private set

    var emailError by mutableStateOf<String?>(null)
        private set

    val isValid by derivedStateOf {
        Email.isValid(email)
    }

    fun enterEmail(email: String) {
        this.email = email
        this.emailError = when (Email.validate(email)) {
            Email.ValidationResult.VALID -> null
            Email.ValidationResult.EMPTY -> "Email cannot be empty"
            Email.ValidationResult.INVALID_FORMAT -> "Invalid email format"
        }
    }
}

@Composable
internal fun rememberForgotPasswordFormState(): ForgotPasswordFormState {
    return remember {
        ForgotPasswordFormState()
    }
}