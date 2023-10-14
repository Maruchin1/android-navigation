package com.maruchin.features.login.changepassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.core.ui.PasswordField

@Composable
internal fun ChangePasswordForm(state: ChangePasswordFormState, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        PasswordField(
            value = state.newPassword,
            onValueChange = state::enterNewPassword,
            label = "New password",
            error = state.newPasswordError,
        )
        Spacer(modifier = Modifier.height(24.dp))
        PasswordField(
            value = state.newPasswordRepeat,
            onValueChange = state::enterNewPasswordRepeat,
            label = "Repeat new password",
            error = state.newPasswordRepeatError,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ChangePasswordFormPreview() {
    MaterialTheme {
        ChangePasswordForm(state = ChangePasswordFormState())
    }
}
