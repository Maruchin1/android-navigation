package com.maruchin.forms.loginform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.maruchin.forms.passwordfield.PasswordFieldState
import com.maruchin.forms.emailfield.EmailFieldState
import com.maruchin.forms.emailfield.rememberEmailFieldState
import com.maruchin.forms.passwordfield.rememberPasswordFieldState

@Stable
class LoginFormState(
    val email: EmailFieldState,
    val password: PasswordFieldState,
) {

    val isValid: Boolean by derivedStateOf {
        email.isValid && password.isValid
    }
}

@Composable
fun rememberLoginFormState(): LoginFormState {
    val email = rememberEmailFieldState()
    val password = rememberPasswordFieldState()
    return remember {
        LoginFormState(email, password)
    }
}
