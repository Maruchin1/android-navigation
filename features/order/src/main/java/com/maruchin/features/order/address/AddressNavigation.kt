package com.maruchin.features.order.address

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val ADDRESS_ROUTE = "address"

internal fun NavGraphBuilder.addressScreen(
    onNavigateBack: () -> Unit,
    onExitOrder: () -> Unit,
    onNavigateToPayment: () -> Unit,
) {
    composable(ADDRESS_ROUTE) {
        val viewModel: AddressViewModel = hiltViewModel()

        AddressScreen(
            onBackClick = onNavigateBack,
            onCancelClick = onExitOrder,
            onNextClick = { address ->
                viewModel.selectAddress(address)
                onNavigateToPayment()
            }
        )
    }
}

internal fun NavController.navigateToAddress() {
    navigate(ADDRESS_ROUTE)
}
