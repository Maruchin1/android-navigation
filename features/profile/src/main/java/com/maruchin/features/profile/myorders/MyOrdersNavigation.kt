package com.maruchin.features.profile.myorders

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val MY_ORDERS_ROUTE = "my-orders"

internal fun NavGraphBuilder.myOrdersScreen(onBack: () -> Unit) {
    composable(MY_ORDERS_ROUTE) {
        MyOrdersScreen(onBack = onBack)
    }
}

internal fun NavController.navigateToMyOrders() {
    navigate(MY_ORDERS_ROUTE)
}
