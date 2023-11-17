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
    firstName: String,
    lastName: String,
    street: String,
    house: String,
    apartment: String?,
    postalCode: String,
    city: String,
    onEditClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = "$firstName $lastName",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "$street $house${apartment?.let { "/$it" } ?: ""}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "$postalCode $city",
                style = MaterialTheme.typography.bodyMedium
            )
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
        firstName = "John",
        lastName = "Doe",
        street = "Street",
        house = "1",
        apartment = null,
        postalCode = "00-000",
        city = "City",
        onEditClick = {}
    )
}
