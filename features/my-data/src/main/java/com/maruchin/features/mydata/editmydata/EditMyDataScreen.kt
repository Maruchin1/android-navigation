package com.maruchin.features.mydata.editmydata

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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun EditMyDataScreen(
    state: EditMyDataUiState,
    onClose: () -> Unit,
    onSaveClick: (firstName: String, lastName: String, email: String, phoneNumber: String) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "My data")
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
            var firstNameInput by rememberSaveable(state.firstName) {
                mutableStateOf(state.firstName)
            }
            OutlinedTextField(
                value = firstNameInput,
                onValueChange = { firstNameInput = it },
                label = {
                    Text(text = "First name")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            var lastNameInput by rememberSaveable(state.lastName) {
                mutableStateOf(state.lastName)
            }
            OutlinedTextField(
                value = lastNameInput,
                onValueChange = { lastNameInput = it },
                label = {
                    Text(text = "Last name")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            var emailInput by rememberSaveable(state.email) {
                mutableStateOf(state.email)
            }
            OutlinedTextField(
                value = emailInput,
                onValueChange = { emailInput = it },
                label = {
                    Text(text = "E-mail")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            var phoneNumberInput by rememberSaveable(state.phoneNumber) {
                mutableStateOf(state.phoneNumber)
            }
            OutlinedTextField(
                value = phoneNumberInput,
                onValueChange = { phoneNumberInput = it },
                label = {
                    Text(text = "Phone number")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    onSaveClick(firstNameInput, lastNameInput, emailInput, phoneNumberInput)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Text(text = "Zapisz")
            }
        }
    }
}

@Preview
@Composable
private fun EditMyDataScreenPreview() {
    EditMyDataScreen(
        state = EditMyDataUiState(
            firstName = "John",
            lastName = "Doe",
            email = "john.doe@gmail.com",
            phoneNumber = "111222333"
        ),
        onClose = {},
        onSaveClick = { _, _, _, _ -> },
    )
}
