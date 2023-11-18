package com.maruchin.features.order

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.features.order.address.addressScreen
import com.maruchin.features.order.address.navigateToAddress
import com.maruchin.features.order.confirmation.confirmationScreen
import com.maruchin.features.order.confirmation.navigateToConfirmation
import com.maruchin.features.order.delivery.DELIVERY_ROUTE
import com.maruchin.features.order.delivery.deliveryScreen
import com.maruchin.features.order.payment.navigateToPayment
import com.maruchin.features.order.payment.paymentScreen
import com.maruchin.features.order.summary.navigateToSummary
import com.maruchin.features.order.summary.summaryScreen

const val ORDER_GRAPH_ROUTE = "order-graph"

fun NavController.navigateToOrderGraph() {
    navigate(ORDER_GRAPH_ROUTE)
}

fun NavGraphBuilder.orderGraph(
    navController: NavController,
    onProductClick: (productId: String) -> Unit
) {

    fun exitOrder() {
        navController.popBackStack(ORDER_GRAPH_ROUTE, inclusive = true)
    }

    navigation(startDestination = DELIVERY_ROUTE, route = ORDER_GRAPH_ROUTE) {
        deliveryScreen(
            onBackClick = {
                navController.navigateUp()
            },
            onDeliveryClick = {
                navController.navigateToAddress()
            },
            onCancelClick = ::exitOrder,
        )
        addressScreen(
            onBackClick = {
                navController.navigateUp()
            },
            onNextClick = {
                navController.navigateToPayment()
            },
            onCancelClick = ::exitOrder,
        )
        paymentScreen(
            onBackClick = {
                navController.navigateUp()
            },
            onPaymentClick = {
                navController.navigateToSummary()
            },
            onCancelClick = ::exitOrder,
        )
        summaryScreen(
            onBackClick = {
                navController.navigateUp()
            },
            onProductClick = onProductClick,
            onSubmitted = {
                navController.navigateToConfirmation()
            },
            onCancelClick = ::exitOrder,
        )
        confirmationScreen(
            onCloseClick = ::exitOrder,
        )
    }
}
