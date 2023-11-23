package com.maruchin.features.order

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
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
import com.maruchin.ui.ROOT_DEEPLINK

const val ORDER_GRAPH_ROUTE = "order-graph"
private const val ORDER_DEEPLINK = "$ROOT_DEEPLINK/order"

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

    navigation(
        startDestination = DELIVERY_ROUTE,
        route = ORDER_GRAPH_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = ORDER_DEEPLINK }
        )
    ) {
        deliveryScreen(
            onBackClick = {
                navController.popBackStack()
            },
            onDeliveryClick = {
                navController.navigateToAddress()
            },
            onCancelClick = ::exitOrder,
        )
        addressScreen(
            onBackClick = {
                navController.popBackStack()
            },
            onNextClick = {
                navController.navigateToPayment()
            },
            onCancelClick = ::exitOrder,
        )
        paymentScreen(
            onBackClick = {
                navController.popBackStack()
            },
            onPaymentClick = {
                navController.navigateToSummary()
            },
            onCancelClick = ::exitOrder,
        )
        summaryScreen(
            onBackClick = {
                navController.popBackStack()
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
