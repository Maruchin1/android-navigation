package com.maruchin.features.order.address

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val ADDRESS_ROUTE = "address"

internal fun NavController.navigateToAddress() {
    navigate(ADDRESS_ROUTE)
}

internal fun NavGraphBuilder.addressScreen(
    onBackClick: () -> Unit,
    onCancelClick: () -> Unit,
    onNextClick: () -> Unit,
) {
    composable(ADDRESS_ROUTE) {
        val viewModel: AddressViewModel = hiltViewModel()

        AddressScreen(
            onBackClick = onBackClick,
            onCancelClick = onCancelClick,
            onNextClick = { address ->
                viewModel.selectAddress(address)
                onNextClick()
            }
        )
    }
}
