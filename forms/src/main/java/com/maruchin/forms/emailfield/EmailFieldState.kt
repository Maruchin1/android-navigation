package com.maruchin.forms.emailfield

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.maruchin.data.user.EmailValidationResult
import com.maruchin.data.user.isEmailValid
import com.maruchin.data.user.validateEmail

@Stable
class EmailFieldState(initialValue: String) {

    var value: String by mutableStateOf(initialValue)
        private set

    var error: String? by mutableStateOf(null)
        private set

    val isValid: Boolean by derivedStateOf {
        isEmailValid(value)
    }

    fun onValueChanged(newValue: String) {
        value = newValue
        error = when (validateEmail(newValue)) {
            EmailValidationResult.VALID -> null
            EmailValidationResult.EMPTY -> "Email cannot be empty"
            EmailValidationResult.INVALID_FORMAT -> "Invalid email format"
        }
    }
}

private val emailFieldSaver = listSaver(
    save = {
        listOf(it.value)
    },
    restore = {
        EmailFieldState(it[0])

    }
)

@Composable
fun rememberEmailFieldState(): EmailFieldState {
    return rememberSaveable(saver = emailFieldSaver) {
        EmailFieldState(initialValue = "")
    }
}
