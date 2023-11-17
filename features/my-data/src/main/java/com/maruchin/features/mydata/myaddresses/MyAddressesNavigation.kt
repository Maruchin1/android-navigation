package com.maruchin.features.mydata.myaddresses

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val MY_ADDRESSES_ROUTE = "my-addresses"

internal fun NavGraphBuilder.myAddresses(
    onBack: () -> Unit,
    onNavigateToAddAddress: () -> Unit,
    onNavigateToEditAddress: (addressId: String) -> Unit
) {
    composable(MY_ADDRESSES_ROUTE) {
        val viewModel: MyAddressesViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        MyAddressesScreen(
            state = state,
            onBack = onBack,
            onAddAddressClick = onNavigateToAddAddress,
            onEditAddress = onNavigateToEditAddress,
        )
    }
}

internal fun NavController.navigateToMyAddresses() {
    navigate(MY_ADDRESSES_ROUTE)
}
