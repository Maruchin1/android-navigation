package com.maruchin.forms.passwordfield

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.maruchin.data.user.PasswordValidationResult
import com.maruchin.data.user.isPasswordValid
import com.maruchin.data.user.validatePassword

@Stable
class PasswordFieldState(initialValue: String) {

    var value: String by mutableStateOf(initialValue)
        private set

    var error: String? by mutableStateOf(null)
        private set

    val isValid: Boolean by derivedStateOf {
        isPasswordValid(value)
    }

    fun onValueChanged(newValue: String) {
        value = newValue
        error = when (validatePassword(newValue)) {
            PasswordValidationResult.VALID -> null
            PasswordValidationResult.EMPTY -> "Password cannot be empty"
        }
    }
}

private val passwordFieldSaver = listSaver(
    save = {
        listOf(it.value)
    },
    restore = {
        PasswordFieldState(it[0])
    }

)

@Composable
fun rememberPasswordFieldState(): PasswordFieldState {
    return rememberSaveable(saver = passwordFieldSaver) {
        PasswordFieldState(initialValue = "")
    }
}