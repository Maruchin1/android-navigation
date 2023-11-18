package com.maruchin.features.login.forgotpassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.features.login.R
import com.maruchin.forms.emailfield.EmailField
import com.maruchin.forms.emailfield.rememberEmailFieldState

@Composable
internal fun ForgotPasswordScreen(
    emailSent: Boolean,
    onBackClick: () -> Unit,
    onSendLinkClick: (email: String) -> Unit,
    onEmailSentInformationShow: () -> Unit,
    onOpenEmailBoxClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(onBack = onBackClick)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val emailState = rememberEmailFieldState()

            Spacer(modifier = Modifier.height(32.dp))
            Explanation()
            Spacer(modifier = Modifier.height(32.dp))
            EmailField(
                state = emailState,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            SendLinkButton(
                enabled = emailState.isValid,
                onClick = {
                    onSendLinkClick(emailState.value)
                }
            )
        }
    }
    if (emailSent) {
        EmailSentDialog(
            onDismiss = onEmailSentInformationShow,
            onOpenEmailBoxClick = onOpenEmailBoxClick
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopAppBar(onBack: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.password_change))
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        }
    )
}

@Composable
private fun Explanation() {
    Text(
        text = stringResource(R.string.password_change_explanation),
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(horizontal = 24.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun SendLinkButton(enabled: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
    ) {
        Text(text = stringResource(R.string.send_link))
    }
}

@Preview
@Composable
private fun ForgotPasswordScreenPreview() {
    MaterialTheme {
        ForgotPasswordScreen(
            emailSent = true,
            onBackClick = {},
            onSendLinkClick = {},
            onOpenEmailBoxClick = {},
            onEmailSentInformationShow = {},
        )
    }
}
