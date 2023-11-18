package com.maruchin.forms.passwordsform

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.maruchin.forms.R
import com.maruchin.forms.passwordfield.PasswordField

@Composable
fun PasswordsForm(
    modifier: Modifier = Modifier,
    state: PasswordsFormState = rememberNewPasswordFormState(),
    firstLabel: String = stringResource(R.string.password),
    secondLabel: String = stringResource(R.string.repeat_password)
) {
    Column(modifier = modifier) {
        PasswordField(state = state.firstPassword, label = firstLabel)
        Spacer(modifier = Modifier.height(24.dp))
        PasswordField(state = state.secondPassword, label = secondLabel)
    }
}