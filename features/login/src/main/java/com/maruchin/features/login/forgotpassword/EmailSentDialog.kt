package com.maruchin.features.login.forgotpassword

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun EmailSentDialog(onDismiss: () -> Unit, onOpenEmailBoxClick: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = null)
        },
        title = {
            Text(text = "Check your email")
        },
        text = {
            Text(text = "To change your password, use the link we sent to the email address provided")
        },
        confirmButton = {
            Button(onClick = onOpenEmailBoxClick, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Open your email box")
            }
        }
    )
}

@Preview
@Composable
private fun EmailSentDialogPreview() {
    EmailSentDialog(onDismiss = {}, onOpenEmailBoxClick = {})
}