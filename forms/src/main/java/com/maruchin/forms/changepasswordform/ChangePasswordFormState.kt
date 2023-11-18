package com.maruchin.forms.changepasswordform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.maruchin.forms.passwordfield.PasswordFieldState
import com.maruchin.forms.passwordsform.PasswordsFormState
import com.maruchin.forms.passwordsform.rememberNewPasswordFormState
import com.maruchin.forms.passwordfield.rememberPasswordFieldState

@Stable
class ChangePasswordFormState(
    val currentPassword: PasswordFieldState,
    val newPassword: PasswordsFormState,
) {

    val isValid: Boolean by derivedStateOf {
        currentPassword.isValid && newPassword.isValid
    }
}

@Composable
fun rememberChangePasswordFormState(): ChangePasswordFormState {
    val currentPassword = rememberPasswordFieldState()
    val newPassword = rememberNewPasswordFormState()

    return remember(currentPassword, newPassword) {
        ChangePasswordFormState(
            currentPassword = currentPassword,
            newPassword = newPassword,
        )
    }
}
