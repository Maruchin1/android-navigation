package com.maruchin.features.mydata.editaddress

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.features.mydata.addressform.AddressForm
import com.maruchin.features.mydata.addressform.rememberAddressFormState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun EditAddressScreen(
    state: EditAddressUiState,
    onClose: () -> Unit,
    onSaveClick: (
        firstName: String,
        lastName: String,
        street: String,
        house: String,
        apartment: String,
        postalCode: String,
        city: String,
    ) -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Edit address")
                },
                navigationIcon = {
                    IconButton(onClick = onClose) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            val formState = rememberAddressFormState()

            LaunchedEffect(state) {
                formState.firstName = state.firstName
                formState.lastName = state.lastName
                formState.street = state.street
                formState.house = state.house
                formState.apartment = state.apartment
                formState.postalCode = state.postalCode
                formState.city = state.city
            }

            AddressForm(state = formState)
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    onSaveClick(
                        formState.firstName,
                        formState.lastName,
                        formState.street,
                        formState.house,
                        formState.apartment,
                        formState.postalCode,
                        formState.city,
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                enabled = formState.isValid,
            ) {
                Text(text = "Save")
            }
        }
    }
}

@Preview
@Composable
private fun EditAddressScreenPreview() {
    EditAddressScreen(
        state = EditAddressUiState(),
        onClose = {},
        onSaveClick = { _, _, _, _, _, _, _ -> }
    )
}
