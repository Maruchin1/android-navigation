package com.maruchin.features.order.summary

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val SUMMARY_ROUTE = "summary"

internal fun NavController.navigateToSummary() {
    navigate(SUMMARY_ROUTE)
}

internal fun NavGraphBuilder.summaryScreen(
    onBackClick: () -> Unit,
    onProductClick: (productId: String) -> Unit,
    onCancelClick: () -> Unit,
    onSubmitted: () -> Unit,
) {
    composable(SUMMARY_ROUTE) {
        val viewModel: SummaryViewModel = hiltViewModel()
        val order by viewModel.order.collectAsState()
        val isSubmitted by viewModel.isSubmitted.collectAsState()

        if (isSubmitted) {
            LaunchedEffect(Unit) {
                onSubmitted()
            }
        }

        SummaryScreen(
            order = order,
            onBackClick = onBackClick,
            onProductClick = onProductClick,
            onSubmitOrderClick = viewModel::submit,
            onCancelClick = onCancelClick,
        )
    }
}
