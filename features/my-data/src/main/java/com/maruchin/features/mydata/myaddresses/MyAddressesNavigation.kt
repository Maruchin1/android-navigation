package com.maruchin.features.mydata.myaddresses

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val MY_ADDRESSES_ROUTE = "my-addresses"

internal fun NavController.navigateToMyAddresses() {
    navigate(MY_ADDRESSES_ROUTE)
}

internal fun NavGraphBuilder.myAddresses(
    onBackClick: () -> Unit,
    onAddAddressClick: () -> Unit,
    onEditAddressClick: (addressId: String) -> Unit
) {
    composable(MY_ADDRESSES_ROUTE) {
        val viewModel: MyAddressesViewModel = hiltViewModel()
        val addresses by viewModel.addresses.collectAsState()

        MyAddressesScreen(
            addresses = addresses,
            onBackClick = onBackClick,
            onAddAddressClick = onAddAddressClick,
            onEditAddressClick = onEditAddressClick,
        )
    }
}
