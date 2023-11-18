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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maruchin.ui.AddressItem
import com.maruchin.data.addresses.Address
import com.maruchin.data.addresses.sampleAddress
import com.maruchin.features.mydata.R

@Composable
internal fun MyAddressesScreen(
    addresses: List<Address>,
    onBackClick: () -> Unit,
    onAddAddressClick: () -> Unit,
    onEditAddressClick: (addressId: String) -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar(onBackClick = onBackClick, onAddAddressClick = onAddAddressClick)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            addresses.forEach { address ->
                AddressItem(
                    firstName = address.firstName,
                    lastName = address.lastName,
                    street = address.street,
                    house = address.house,
                    apartment = address.apartment,
                    postalCode = address.postalCode,
                    city = address.postalCode,
                    onEditClick = { onEditAddressClick(address.id) }
                )
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(onBackClick: () -> Unit, onAddAddressClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.my_addresses))
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            TextButton(onClick = onAddAddressClick) {
                Text(text = stringResource(R.string.add))
            }
        }
    )
}

@Preview
@Composable
private fun MyAddressesScreenPreview() {
    MyAddressesScreen(
        addresses = listOf(sampleAddress),
        onBackClick = {},
        onAddAddressClick = {},
        onEditAddressClick = {},
    )
}
