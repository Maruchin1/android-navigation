package com.maruchin.features.login.login

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.core.ui.Loading

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LoginScreen(
    loginFormState: LoginFormState,
    isLoading: Boolean,
    onBack: () -> Unit,
    onLogin: () -> Unit,
    onRegister: () -> Unit,
    onForgotPassword: () -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        Crossfade(targetState = isLoading, label = "") { isLoading ->
            if (isLoading) {
                Loading()
            } else {
                Column(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = "Login", style = MaterialTheme.typography.displayMedium)
                    Spacer(modifier = Modifier.height(64.dp))
                    LoginForm(
                        state = loginFormState,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    TextButton(
                        onClick = onForgotPassword,
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(end = 16.dp, top = 8.dp)
                    ) {
                        Text(text = "Forgot password?")
                    }
                    Spacer(modifier = Modifier.height(48.dp))
                    Button(
                        onClick = onLogin,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        enabled = loginFormState.isValid,
                    ) {
                        Text(text = "Login")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedButton(
                        onClick = onRegister,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                    ) {
                        Text(text = "Register")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen(
            loginFormState = rememberLoginFormState(),
            isLoading = false,
            onBack = {},
            onLogin = {},
            onRegister = {},
            onForgotPassword = {},
        )
    }
}
