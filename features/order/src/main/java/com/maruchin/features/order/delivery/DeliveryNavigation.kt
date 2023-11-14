package com.maruchin.features.order.delivery

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val DELIVERY_ROUTE = "delivery"

internal fun NavGraphBuilder.deliveryScreen(
    onNavigateBack: () -> Unit,
    onExitOrder: () -> Unit,
    onNavigateToAddress: () -> Unit
) {
    composable(DELIVERY_ROUTE) {
        val viewModel: DeliveryViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        DeliveryScreen(
            state = state,
            onBackClick = onNavigateBack,
            onCancelClick = onExitOrder,
            onSelectDelivery = { deliveryId ->
                viewModel.selectDelivery(deliveryId)
                onNavigateToAddress()
            },
        )
    }
}
