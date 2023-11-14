package com.maruchin.features.favorites

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.data.products.Product

const val FAVORITES_GRAPH_ROUTE = "favorites-graph"

fun NavGraphBuilder.favoritesGraph(onNavigateToProductCard: (Product) -> Unit) {
    navigation(startDestination = FAVORITES_ROUTE, route = FAVORITES_GRAPH_ROUTE) {
        favoritesScreen(
            onNavigateToProductCard = onNavigateToProductCard
        )
    }
}
