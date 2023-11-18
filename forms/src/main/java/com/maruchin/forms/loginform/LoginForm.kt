package com.maruchin.forms.loginform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.forms.passwordfield.PasswordField
import com.maruchin.forms.emailfield.EmailField

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    state: LoginFormState = rememberLoginFormState()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        EmailField(state = state.email)
        PasswordField(state = state.password)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun LoginFormPreview() {
    MaterialTheme {
        LoginForm(modifier = Modifier.padding(16.dp))
    }
}