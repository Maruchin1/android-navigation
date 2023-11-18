package com.maruchin.forms.addressform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.maruchin.forms.R
import com.maruchin.forms.textfield.TextField

@Composable
fun AddressForm(
    modifier: Modifier = Modifier,
    state: AddressFormState = rememberAddressFormState()
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        TextField(label = stringResource(R.string.first_name), state = state.firstName)
        TextField(label = stringResource(R.string.last_name), state = state.lastName)
        TextField(label = stringResource(R.string.street), state = state.street)
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            TextField(
                label = stringResource(R.string.house),
                state = state.house,
                modifier = Modifier.weight(1f)
            )
            TextField(
                label = stringResource(R.string.apartment),
                state = state.apartment,
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            TextField(
                label = stringResource(R.string.postal_code),
                state = state.postalCode,
                modifier = Modifier.weight(1f)
            )
            TextField(
                label = stringResource(R.string.city),
                state = state.city,
                modifier = Modifier.weight(1f)
            )
        }
    }
}