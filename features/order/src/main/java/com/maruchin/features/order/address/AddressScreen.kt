package com.maruchin.features.order.address

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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.data.addresses.Address
import com.maruchin.data.addresses.sampleAddress
import com.maruchin.features.order.R
import com.maruchin.forms.addressform.AddressForm
import com.maruchin.forms.addressform.rememberAddressFormState

@Composable
internal fun AddressScreen(
    onBackClick: () -> Unit,
    onNextClick: (Address) -> Unit,
    onCancelClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(onBackClick = onBackClick, onCancelClick = onCancelClick)
        }
    ) { padding ->
        val formState = rememberAddressFormState()

        LaunchedEffect(Unit) {
            formState.address = sampleAddress
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            AddressForm(
                state = formState,
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            NextButton(
                enabled = formState.isValid,
                onClick = { onNextClick(formState.address) }
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(onBackClick: () -> Unit, onCancelClick: () -> Unit) {
    Column {
        CenterAlignedTopAppBar(
            title = {
                Text(text = stringResource(R.string.address))
            },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                TextButton(onClick = onCancelClick) {
                    Text(text = stringResource(R.string.cancel))
                }
            }
        )
        LinearProgressIndicator(progress = 0.5f, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
private fun NextButton(enabled: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        enabled = enabled
    ) {
        Text(text = stringResource(R.string.next))
    }
}

@Preview
@Composable
private fun AddressScreenPreview() {
    AddressScreen(onBackClick = {}, onNextClick = {}, onCancelClick = {})
}
