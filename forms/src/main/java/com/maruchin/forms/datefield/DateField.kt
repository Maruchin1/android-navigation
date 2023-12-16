package com.maruchin.forms.datefield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateField(
    label: String,
    modifier: Modifier = Modifier,
    state: DateFieldState = rememberDateFieldState()
) {
    OutlinedTextField(
        value = state.selectedDateText,
        readOnly = true,
        onValueChange = {},
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.CalendarToday, contentDescription = null)
        },
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
            .onFocusChanged(state::onFocusChange),
    )

    if (state.isDialogOpen) {
        DatePickerDialog(
            onDismissRequest = state::onDismiss,
            confirmButton = {}
        ) {
            DatePicker(state = state.datePickerState)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DateFieldPreview() {
    DateField(label = "Birth date", modifier = Modifier.padding(16.dp))
}

