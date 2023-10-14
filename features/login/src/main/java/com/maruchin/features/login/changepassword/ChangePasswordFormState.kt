package com.maruchin.features.login.changepassword

import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.maruchin.data.user.Password

@Stable
internal class ChangePasswordFormState {

    var newPassword by mutableStateOf("")
        private set

    var newPasswordError by mutableStateOf<String?>(null)
        private set

    var newPasswordRepeat by mutableStateOf("")
        private set

    var newPasswordRepeatError by mutableStateOf<String?>(null)
        private set

    val isValid by derivedStateOf {
        Password.isValid(newPassword) &&
                Password.isValid(newPasswordRepeat) &&
                newPassword == newPasswordRepeat
    }

    fun enterNewPassword(password: String) {
        newPassword = password
        newPasswordError = when (Password.validate(password)) {
            Password.ValidationResult.VALID -> null
            Password.ValidationResult.EMPTY -> "Password cannot be empty"
        }
    }

    fun enterNewPasswordRepeat(password: String) {
        newPasswordRepeat = password
        newPasswordRepeatError = when (Password.validate(password)) {
            Password.ValidationResult.VALID -> when {
                password != newPassword -> "Passwords are not the same"
                else -> null
            }
            Password.ValidationResult.EMPTY -> "Password cannot be empty"
        }
    }
}