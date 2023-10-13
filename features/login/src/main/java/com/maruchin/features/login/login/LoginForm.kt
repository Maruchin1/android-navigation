package com.maruchin.features.login.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.core.ui.EmailField
import com.maruchin.core.ui.PasswordField

@Composable
internal fun LoginForm(
    modifier: Modifier = Modifier,
    state: LoginFormState = rememberLoginFormState()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        EmailField(
            value = state.email,
            onValueChange = state::enterEmail,
            error = state.emailError,
        )
        PasswordField(
            value = state.password,
            onValueChange = state::enterPassword,
            error = state.passwordError,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun LoginFormPreview() {
    MaterialTheme {
        LoginForm(modifier = Modifier.padding(16.dp))
    }
}