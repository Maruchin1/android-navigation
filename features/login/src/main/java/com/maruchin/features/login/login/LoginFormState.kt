package com.maruchin.features.login.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.maruchin.data.user.EmailValidationResult
import com.maruchin.data.user.PasswordValidationResult
import com.maruchin.data.user.isEmailValid
import com.maruchin.data.user.isPasswordValid
import com.maruchin.data.user.validateEmail
import com.maruchin.data.user.validatePassword

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
        isEmailValid(email) && isPasswordValid(password)
    }

    fun enterEmail(email: String) {
        this.email = email
        emailError = when (validateEmail(email)) {
            EmailValidationResult.VALID -> null
            EmailValidationResult.EMPTY -> "Email cannot be empty"
            EmailValidationResult.INVALID_FORMAT -> "Invalid email format"
        }
    }

    fun enterPassword(password: String) {
        this.password = password
        passwordError = when (validatePassword(password)) {
            PasswordValidationResult.VALID -> null
            PasswordValidationResult.EMPTY -> "Password cannot be empty"
        }
    }
}

@Composable
internal fun rememberLoginFormState(): LoginFormState {
    return remember {
        LoginFormState()
    }
}