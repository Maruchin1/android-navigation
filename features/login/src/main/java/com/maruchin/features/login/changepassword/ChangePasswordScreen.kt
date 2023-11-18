package com.maruchin.features.login.changepassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.features.login.R
import com.maruchin.forms.passwordsform.PasswordsForm
import com.maruchin.forms.passwordsform.rememberNewPasswordFormState

@Composable
internal fun ChangePasswordScreen(
    onCloseClick: () -> Unit,
    onChangePasswordClick: (newPassword: String) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(onCloseClick = onCloseClick)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val formState = rememberNewPasswordFormState()

            Spacer(modifier = Modifier.height(32.dp))
            Header()
            Spacer(modifier = Modifier.height(32.dp))
            PasswordsForm(
                state = formState,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            ChangePasswordButton(
                isEnabled = formState.isValid,
                onClick = {
                    onChangePasswordClick(formState.firstPassword.value)
                }
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopAppBar(onCloseClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.password_change))
        },
        navigationIcon = {
            IconButton(onClick = onCloseClick) {
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }
        }
    )
}

@Composable
private fun Header() {
    Text(
        text = stringResource(R.string.change_your_password),
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(horizontal = 24.dp)
    )
}

@Composable
private fun ChangePasswordButton(isEnabled: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth(),
        enabled = isEnabled
    ) {
        Text(text = stringResource(R.string.change_password))
    }
}

@Preview
@Composable
private fun ChangePasswordScreenPreview() {
    ChangePasswordScreen(
        onCloseClick = {},
        onChangePasswordClick = {}
    )
}
