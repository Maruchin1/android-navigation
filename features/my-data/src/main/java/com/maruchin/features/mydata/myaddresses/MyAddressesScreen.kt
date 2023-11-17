package com.maruchin.features.mydata.myaddresses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maruchin.core.ui.AddressItem
import com.maruchin.data.addresses.sampleAddress

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MyAddressesScreen(
    state: MyAddressesUiState,
    onBack: () -> Unit,
    onAddAddressClick: () -> Unit,
    onEditAddress: (addressId: String) -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "My addresses")
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    TextButton(onClick = onAddAddressClick) {
                        Text(text = "Add")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            state.addresses.forEach { address ->
                AddressItem(
                    firstName = address.firstName,
                    lastName = address.lastName,
                    street = address.street,
                    house = address.house,
                    apartment = address.apartment,
                    postalCode = address.postalCode,
                    city = address.postalCode,
                    onEditClick = { onEditAddress(address.id) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun MyAddressesScreenPreview() {
    MyAddressesScreen(
        state = MyAddressesUiState(addresses = listOf(sampleAddress)),
        onBack = {},
        onAddAddressClick = {},
        onEditAddress = {},
    )
}
