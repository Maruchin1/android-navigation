package com.maruchin.features.order.confirmation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.features.order.ORDER_GRAPH_ROUTE

internal const val CONFIRMATION_ROUTE = "confirmation"

internal fun NavGraphBuilder.confirmationScreen(onExitOrder: () -> Unit) {
    composable(CONFIRMATION_ROUTE) {
        val viewModel: ConfirmationViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        ConfirmationScreen(
            state = state,
            onCloseClick = onExitOrder,
        )
    }
}

internal fun NavController.navigateToConfirmation() {
    navigate(CONFIRMATION_ROUTE) {
        popUpTo(ORDER_GRAPH_ROUTE)
    }
}
