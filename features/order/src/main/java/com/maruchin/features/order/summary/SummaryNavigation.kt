package com.maruchin.features.order.summary

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.order.Order
import com.maruchin.data.products.Product

internal const val SUMMARY_ROUTE = "summary"

internal fun NavGraphBuilder.summaryScreen(
    onNavigateBack: () -> Unit,
    onNavigateToProductCard: (Product) -> Unit,
    onNavigateToConfirmation: () -> Unit,
    onExitOrder: () -> Unit,
) {
    composable(SUMMARY_ROUTE) {
        val viewModel: SummaryViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        if (state.order is Order.Submitted) {
            LaunchedEffect(Unit) {
                onNavigateToConfirmation()
            }
        }

        SummaryScreen(
            state = state,
            onBackClick = onNavigateBack,
            onProductClick = onNavigateToProductCard,
            onSubmitOrderClick = viewModel::submit,
            onCancelClick = onExitOrder,
        )
    }
}

internal fun NavController.navigateToSummary() {
    navigate(SUMMARY_ROUTE)
}
