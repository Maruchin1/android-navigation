package com.maruchin.features.mydata.addressform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun AddressForm(state: AddressFormState = rememberAddressFormState()) {
    Column {
        OutlinedTextField(
            value = state.firstName,
            onValueChange = { state.firstName = it },
            label = {
                Text(text = "First name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        OutlinedTextField(
            value = state.lastName,
            onValueChange = { state.lastName = it },
            label = {
                Text(text = "Last name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        OutlinedTextField(
            value = state.street,
            onValueChange = { state.street = it },
            label = {
                Text(text = "Street")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = state.house,
                onValueChange = { state.house = it },
                label = {
                    Text(text = "House")
                },
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = state.apartment,
                onValueChange = { state.apartment = it },
                label = {
                    Text(text = "Apartment")
                },
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            OutlinedTextField(
                value = state.postalCode,
                onValueChange = { state.postalCode = it },
                label = {
                    Text(text = "Postal code")
                },
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = state.city,
                onValueChange = { state.city = it },
                label = {
                    Text(text = "City")
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}