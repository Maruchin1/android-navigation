package com.maruchin.features.cart

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.data.products.ProductId
import com.maruchin.features.cart.cart.CART_ROUTE
import com.maruchin.features.cart.cart.cartScreen

const val CART_GRAPH_ROUTE = "loremipsum"

fun NavGraphBuilder.cartGraph(
    onNavigateToOrder: () -> Unit,
    onNavigateToProduct: (ProductId) -> Unit,
) {
    navigation(startDestination = CART_ROUTE, route = CART_GRAPH_ROUTE) {
        cartScreen(
            onNavigateToOrder = onNavigateToOrder,
            onNavigateToProduct = onNavigateToProduct,
        )
    }
}
