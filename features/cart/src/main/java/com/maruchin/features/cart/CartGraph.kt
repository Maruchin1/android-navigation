package com.maruchin.features.cart

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

const val CART_GRAPH_ROUTE = "cart-graph"

fun NavGraphBuilder.cartGraph(
    onNextClick: () -> Unit,
    onProductClick: (product: String) -> Unit,
) {
    navigation(startDestination = CART_ROUTE, route = CART_GRAPH_ROUTE) {
        cartScreen(
            onNextClick = onNextClick,
            onProductClick = onProductClick,
        )
    }
}
