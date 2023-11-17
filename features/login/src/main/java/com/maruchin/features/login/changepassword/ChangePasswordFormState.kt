package com.maruchin.features.login.changepassword

import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.maruchin.data.user.PasswordValidationResult
import com.maruchin.data.user.arePasswordsValid
import com.maruchin.data.user.validatePassword

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
        arePasswordsValid(newPassword, newPasswordRepeat)
    }

    fun enterNewPassword(password: String) {
        newPassword = password
        newPasswordError = when (validatePassword(password)) {
            PasswordValidationResult.VALID -> null
            PasswordValidationResult.EMPTY -> "Password cannot be empty"
        }
    }

    fun enterNewPasswordRepeat(password: String) {
        newPasswordRepeat = password
        newPasswordRepeatError = when (validatePassword(password)) {
            PasswordValidationResult.VALID -> when {
                password != newPassword -> "Passwords are not the same"
                else -> null
            }
            PasswordValidationResult.EMPTY -> "Password cannot be empty"
        }
    }
}