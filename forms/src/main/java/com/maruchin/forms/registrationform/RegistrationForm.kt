package com.maruchin.forms.registrationform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.forms.passwordsform.PasswordsForm
import com.maruchin.forms.personaldataform.PersonalDataForm

@Composable
fun RegistrationForm(
    modifier: Modifier = Modifier,
    state: RegistrationFormState = rememberRegistrationFormState(),
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        PersonalDataForm(state = state.personalData)
        PasswordsForm(state = state.passwords)
    }
}
