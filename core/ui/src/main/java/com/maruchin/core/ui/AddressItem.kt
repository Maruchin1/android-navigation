package com.maruchin.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddressItem(
    fullName: String,
    firstLine: String,
    secondLine: String,
    onEditClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = fullName, style = MaterialTheme.typography.titleMedium)
            Text(text = firstLine, style = MaterialTheme.typography.bodyMedium)
            Text(text = secondLine, style = MaterialTheme.typography.bodyMedium)
        }
        if (onEditClick != null) {
            IconButton(onClick = onEditClick) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }
        }
    }
    Divider(modifier = Modifier.padding(horizontal = 16.dp))
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun AddressItemPreview() {
    AddressItem(
        fullName = "John Doe",
        firstLine = "Street 1",
        secondLine = "City, Country",
        onEditClick = {}
    )
}
