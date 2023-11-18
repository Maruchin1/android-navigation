package com.maruchin.features.favorites

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

const val FAVORITES_GRAPH_ROUTE = "favorites-graph"

fun NavGraphBuilder.favoritesGraph(onProductClick: (productId: String) -> Unit) {
    navigation(startDestination = FAVORITES_ROUTE, route = FAVORITES_GRAPH_ROUTE) {
        favoritesScreen(
            onProductClick = onProductClick
        )
    }
}
