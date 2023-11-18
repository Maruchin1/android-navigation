package com.maruchin.forms.changepasswordform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.maruchin.forms.R
import com.maruchin.forms.passwordfield.PasswordField
import com.maruchin.forms.passwordsform.PasswordsForm

@Composable
fun ChangePasswordForm(
    modifier: Modifier = Modifier,
    state: ChangePasswordFormState = rememberChangePasswordFormState()
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(32.dp)) {
        PasswordField(
            label = stringResource(R.string.current_password),
            state = state.currentPassword
        )
        PasswordsForm(
            state = state.newPassword,
            firstLabel = stringResource(R.string.new_password),
            secondLabel = stringResource(R.string.repeat_new_password),
        )
    }
}