package com.maruchin.forms.emailfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.forms.R

@Composable
fun EmailField(
    modifier: Modifier = Modifier,
    state: EmailFieldState = rememberEmailFieldState()
) {
    OutlinedTextField(
        value = state.value,
        onValueChange = state::onValueChanged,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        label = {
            Text(text = stringResource(R.string.email))
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = null)
        },
        isError = state.error != null,
        supportingText = state.error?.let {
            {
                Text(text = it, style = MaterialTheme.typography.bodySmall, color = Color.Red)
            }
        }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun EmailFieldPreview() {
    MaterialTheme {
        EmailField(modifier = Modifier.padding(16.dp))
    }
}