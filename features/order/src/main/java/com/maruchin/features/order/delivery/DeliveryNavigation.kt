package com.maruchin.features.order.delivery

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val DELIVERY_ROUTE = "delivery"

internal fun NavGraphBuilder.deliveryScreen(
    onBackClick: () -> Unit,
    onCancelClick: () -> Unit,
    onDeliveryClick: () -> Unit
) {
    composable(DELIVERY_ROUTE) {
        val viewModel: DeliveryViewModel = hiltViewModel()
        val state by viewModel.deliveries.collectAsState()

        DeliveryScreen(
            deliveries = state,
            onBackClick = onBackClick,
            onCancelClick = onCancelClick,
            onDeliveryClick = { delivery ->
                viewModel.selectDelivery(delivery)
                onDeliveryClick()
            },
        )
    }
}
