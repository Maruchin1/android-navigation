package com.maruchin.features.login.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.maruchin.data.user.Email
import com.maruchin.data.user.Password

@Stable
internal class LoginFormState {

    var email by mutableStateOf("")
        private set

    var emailError by mutableStateOf<String?>(null)
        private set

    var password by mutableStateOf("")
        private set

    var passwordError by mutableStateOf<String?>(null)
        private set

    val isValid by derivedStateOf {
        Email.validate(email) == Email.ValidationResult.VALID &&
                Password.validate(password) == Password.ValidationResult.VALID
    }

    fun enterEmail(email: String) {
        this.email = email
        emailError = when (Email.validate(email)) {
            Email.ValidationResult.VALID -> null
            Email.ValidationResult.EMPTY -> "Email cannot be empty"
            Email.ValidationResult.INVALID_FORMAT -> "Invalid email format"
        }
    }

    fun enterPassword(password: String) {
        this.password = password
        passwordError = when (Password.validate(password)) {
            Password.ValidationResult.VALID -> null
            Password.ValidationResult.EMPTY -> "Password cannot be empty"
        }
    }
}

@Composable
internal fun rememberLoginFormState(): LoginFormState {
    return remember {
        LoginFormState()
    }
}