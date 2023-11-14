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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.core.forms.addressform.AddressForm
import com.maruchin.core.forms.addressform.rememberAddressFormState
import com.maruchin.data.addresses.Address
import com.maruchin.data.addresses.sampleAddress

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddressScreen(
    onBackClick: () -> Unit,
    onNextClick: (Address) -> Unit,
    onCancelClick: () -> Unit
) {
    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Address")
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                        }
                    },
                    actions = {
                        TextButton(onClick = onCancelClick) {
                            Text(text = "Cancel")
                        }
                    }
                )
                LinearProgressIndicator(progress = 0.5f, modifier = Modifier.fillMaxWidth())
            }
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
            AddressForm(state = formState)
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { onNextClick(formState.address) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                enabled = formState.isValid
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview
@Composable
private fun AddressScreenPreview() {
    AddressScreen(onBackClick = {}, onNextClick = {}, onCancelClick = {})
}
