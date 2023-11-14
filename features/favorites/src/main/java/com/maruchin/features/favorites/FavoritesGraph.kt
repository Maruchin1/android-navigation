package com.maruchin.features.favorites

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.data.products.ProductId

const val FAVORITES_GRAPH_ROUTE = "favorites-graph"

fun NavGraphBuilder.favoritesGraph(onNavigateToProductCard: (ProductId) -> Unit) {
    navigation(startDestination = FAVORITES_ROUTE, route = FAVORITES_GRAPH_ROUTE) {
        favoritesScreen(
            onNavigateToProductCard = onNavigateToProductCard
        )
    }
}
