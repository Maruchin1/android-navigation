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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.forms.addressform.AddressForm
import com.maruchin.forms.addressform.rememberAddressFormState
import com.maruchin.data.addresses.Address
import com.maruchin.data.addresses.sampleAddress
import com.maruchin.features.mydata.R

@Composable
internal fun EditAddressScreen(
    address: Address?,
    onCloseClick: () -> Unit,
    onSaveClick: (Address) -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar(onCloseClick)
        }
    ) { padding ->
        if (address == null) return@Scaffold

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            val formState = rememberAddressFormState()

            LaunchedEffect(address) {
                formState.address = address
            }

            AddressForm(
                state = formState,
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            SaveButton(
                enabled = formState.isValid,
                onClick = {
                    onSaveClick(formState.address)
                }
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(onClose: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.edit_address))
        },
        navigationIcon = {
            IconButton(onClick = onClose) {
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }
        }
    )
}

@Composable
private fun SaveButton(enabled: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        enabled = enabled,
    ) {
        Text(text = stringResource(R.string.save))
    }
}

@Preview
@Composable
private fun EditAddressScreenPreview() {
    EditAddressScreen(
        address = sampleAddress,
        onCloseClick = {},
        onSaveClick = {}
    )
}
