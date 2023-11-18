package com.maruchin.features.order.payment

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val PAYMENT_ROUTE = "payment"

internal fun NavController.navigateToPayment() {
    navigate(PAYMENT_ROUTE)
}

internal fun NavGraphBuilder.paymentScreen(
    onBackClick: () -> Unit,
    onPaymentClick: () -> Unit,
    onCancelClick: () -> Unit,
) {
    composable(PAYMENT_ROUTE) {
        val viewModel: PaymentViewModel = hiltViewModel()
        val state by viewModel.payments.collectAsState()

        PaymentScreen(
            payments = state,
            onBackClick = onBackClick,
            onCancelClick = onCancelClick,
            onPaymentClick = { payment ->
                viewModel.selectPayment(payment)
                onPaymentClick()
            }
        )
    }
}
