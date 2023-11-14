package com.maruchin.features.order

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.data.products.Product
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

fun NavGraphBuilder.orderGraph(
    navController: NavController,
    onNavigateToProductCard: (Product) -> Unit
) {

    fun exitOrder() {
        navController.popBackStack(ORDER_GRAPH_ROUTE, inclusive = true)
    }

    navigation(startDestination = DELIVERY_ROUTE, route = ORDER_GRAPH_ROUTE) {
        deliveryScreen(
            onNavigateBack = {
                navController.navigateUp()
            },
            onNavigateToAddress = {
                navController.navigateToAddress()
            },
            onExitOrder = ::exitOrder,
        )
        addressScreen(
            onNavigateBack = {
                navController.navigateUp()
            },
            onNavigateToPayment = {
                navController.navigateToPayment()
            },
            onExitOrder = ::exitOrder,
        )
        paymentScreen(
            onNavigateBack = {
                navController.navigateUp()
            },
            onNavigateToSummary = {
                navController.navigateToSummary()
            },
            onExitOrder = ::exitOrder,
        )
        summaryScreen(
            onNavigateBack = {
                navController.navigateUp()
            },
            onNavigateToProductCard = onNavigateToProductCard,
            onNavigateToConfirmation = {
                navController.navigateToConfirmation()
            },
            onExitOrder = ::exitOrder,
        )
        confirmationScreen(
            onExitOrder = ::exitOrder,
        )
    }
}

fun NavController.navigateToOrderGraph() {
    navigate(ORDER_GRAPH_ROUTE)
}
