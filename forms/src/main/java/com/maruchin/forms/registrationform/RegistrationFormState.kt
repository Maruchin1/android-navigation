package com.maruchin.forms.registrationform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.maruchin.forms.passwordsform.PasswordsFormState
import com.maruchin.forms.passwordsform.rememberNewPasswordFormState
import com.maruchin.forms.personaldataform.PersonalDataFormState
import com.maruchin.forms.personaldataform.rememberPersonalDataFormState

@Stable
class RegistrationFormState(
    val personalData: PersonalDataFormState,
    val passwords: PasswordsFormState,
) {

    val isValid: Boolean by derivedStateOf {
        personalData.isValid && passwords.isValid
    }
}

@Composable
fun rememberRegistrationFormState(): RegistrationFormState {
    val personalData = rememberPersonalDataFormState()
    val newPasswordFormState = rememberNewPasswordFormState()

    return remember(personalData, newPasswordFormState) {
        RegistrationFormState(personalData, newPasswordFormState)
    }
}
