package com.maruchin.forms.personaldataform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.maruchin.forms.R
import com.maruchin.forms.textfield.TextField
import com.maruchin.forms.emailfield.EmailField

@Composable
fun PersonalDataForm(
    modifier: Modifier = Modifier,
    state: PersonalDataFormState = rememberPersonalDataFormState()
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        TextField(
            icon = Icons.Default.Person,
            label = stringResource(R.string.first_name),
            state = state.firstName,
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            icon = Icons.Default.Person,
            label = stringResource(R.string.last_name),
            state = state.lastName,
            modifier = Modifier.fillMaxWidth()
        )
        EmailField(
            state = state.email,
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            icon = Icons.Default.Phone,
            label = stringResource(R.string.phone_number),
            state = state.phoneNumber,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
