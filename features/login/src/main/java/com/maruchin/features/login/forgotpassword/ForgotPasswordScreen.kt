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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.core.ui.Loading

@Composable
internal fun ForgotPasswordScreen(
    forgotPasswordFormState: ForgotPasswordFormState,
    emailState: EmailState,
    onBack: () -> Unit,
    onSendLink: () -> Unit,
    onEmailSentInformationShow: () -> Unit,
    onOpenEmailBox: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(onBack = onBack)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Explanation()
            Spacer(modifier = Modifier.height(32.dp))
            ForgotPasswordForm(
                state = forgotPasswordFormState,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            SendLinkButton(enabled = forgotPasswordFormState.isValid, onClick = onSendLink)
        }
        if (emailState is EmailState.Sending) {
            Loading()
        }
    }
    if (emailState is EmailState.Sent) {
        EmailSentDialog(onClose = onEmailSentInformationShow, onOpenEmailBox = onOpenEmailBox)
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopAppBar(onBack: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text("Password change")
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
        text = "Do not you remember the password? Enter your e-mail address to which we will send a link to change your password",
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
        Text(text = "Send link")
    }
}

@Preview
@Composable
private fun ForgotPasswordScreenPreview() {
    MaterialTheme {
        ForgotPasswordScreen(
            forgotPasswordFormState = rememberForgotPasswordFormState(),
            emailState = EmailState.Idle,
            onBack = {},
            onSendLink = {},
            onOpenEmailBox = {},
            onEmailSentInformationShow = {},
        )
    }
}
