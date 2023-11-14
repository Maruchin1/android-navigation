package com.maruchin.features.order.payment

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val PAYMENT_ROUTE = "payment"

internal fun NavGraphBuilder.paymentScreen(
    onNavigateBack: () -> Unit,
    onNavigateToSummary: () -> Unit,
    onExitOrder: () -> Unit,
) {
    composable(PAYMENT_ROUTE) {
        val viewModel: PaymentViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        PaymentScreen(
            state = state,
            onBackClick = onNavigateBack,
            onCancelClick = onExitOrder,
            onPaymentClick = { payment ->
                viewModel.selectPayment(payment)
                onNavigateToSummary()
            }
        )
    }
}

internal fun NavController.navigateToPayment() {
    navigate(PAYMENT_ROUTE)
}
