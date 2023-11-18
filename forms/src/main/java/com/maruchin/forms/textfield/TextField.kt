package com.maruchin.forms.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun TextField(
    label: String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    state: TextFieldState = rememberTextFieldState()
) {
    OutlinedTextField(
        value = state.value,
        onValueChange = { state.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        label = {
            Text(text = label)
        },
        leadingIcon = icon?.let {
            {
                Icon(imageVector = icon, contentDescription = null)
            }
        },
    )
}
