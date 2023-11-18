package com.maruchin.features.order.confirmation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.features.order.ORDER_GRAPH_ROUTE

internal const val CONFIRMATION_ROUTE = "confirmation"

internal fun NavController.navigateToConfirmation() {
    navigate(CONFIRMATION_ROUTE) {
        popUpTo(ORDER_GRAPH_ROUTE)
    }
}

internal fun NavGraphBuilder.confirmationScreen(onCloseClick: () -> Unit) {
    composable(CONFIRMATION_ROUTE) {
        val viewModel: ConfirmationViewModel = hiltViewModel()
        val order by viewModel.order.collectAsState()

        ConfirmationScreen(
            order = order,
            onCloseClick = onCloseClick,
        )
    }
}
