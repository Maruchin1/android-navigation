package com.maruchin.features.registration.registrationform

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.data.user.PersonalData
import com.maruchin.features.registration.R
import com.maruchin.forms.registrationform.RegistrationForm
import com.maruchin.forms.registrationform.rememberRegistrationFormState

@Composable
internal fun RegistrationFormScreen(
    onBackClick: () -> Unit,
    onRegisterClick: (personalData: PersonalData, password: String) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(onBackClick = onBackClick)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            val formState = rememberRegistrationFormState()

            LaunchedEffect(Unit) {
                formState.personalData.run {
                    firstName.value = "John"
                    lastName.value = "Doe"
                    email.onValueChanged("john.doe@gmail.com")
                    phoneNumber.value = "123456789"
                }
                formState.passwords.run {
                    firstPassword.onValueChanged("StrongPassword123")
                    secondPassword.onValueChanged("StrongPassword123")
                }
            }

            RegistrationForm(
                state = formState,
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    onRegisterClick(
                        formState.personalData.personalData,
                        formState.passwords.firstPassword.value
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                enabled = formState.isValid,
            ) {
                Text(text = stringResource(R.string.register))
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(onBackClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.register))
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        }
    )
}

@Preview
@Composable
private fun RegistrationFormScreenPreview() {
    RegistrationFormScreen(onBackClick = {}, onRegisterClick = { _, _ -> })
}
