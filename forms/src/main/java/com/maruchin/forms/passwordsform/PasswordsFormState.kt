package com.maruchin.forms.passwordsform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.maruchin.forms.passwordfield.PasswordFieldState
import com.maruchin.forms.passwordfield.rememberPasswordFieldState

@Stable
class PasswordsFormState(
    val firstPassword: PasswordFieldState,
    val secondPassword: PasswordFieldState,
) {

    val isValid: Boolean by derivedStateOf {
        firstPassword.isValid && secondPassword.isValid && firstPassword.value == secondPassword.value
    }
}

@Composable
fun rememberNewPasswordFormState(): PasswordsFormState {
    val firstPassword = rememberPasswordFieldState()
    val secondPassword = rememberPasswordFieldState()

    return remember(firstPassword, secondPassword) {
        PasswordsFormState(firstPassword, secondPassword)
    }
}
