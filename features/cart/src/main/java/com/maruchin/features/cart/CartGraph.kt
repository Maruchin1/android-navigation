package com.maruchin.features.cart

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.data.products.ProductId

const val CART_GRAPH_ROUTE = "cart-graph"

fun NavGraphBuilder.cartGraph(
    onNavigateToOrder: () -> Unit,
    onNavigateToProduct: (ProductId) -> Unit,
) {
    navigation(startDestination = CART_ROUTE, route = CART_GRAPH_ROUTE) {
        cartScreen(
            onNavigateToOrder = onNavigateToOrder,
            onNavigateToProductCard = onNavigateToProduct,
        )
    }
}
