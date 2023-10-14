package com.maruchin.features.login.forgotpassword

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.core.ui.EmailField

@Composable
internal fun ForgotPasswordForm(state: ForgotPasswordFormState, modifier: Modifier = Modifier) {
    EmailField(
        value = state.email,
        onValueChange = state::enterEmail,
        error = state.emailError,
        modifier = modifier,
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ForgotPasswordFormPreview() {
    MaterialTheme {
        ForgotPasswordForm(state = ForgotPasswordFormState(), modifier = Modifier.padding(16.dp))
    }
}