package com.maruchin.features.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

const val HOME_GRAPH_ROUTE = "home-graph"

fun NavGraphBuilder.homeGraph(
    onNavigateToCategoryBrowser: (categoryId: String) -> Unit,
    onNavigateToProductCard: (productId: String) -> Unit,
    onNavigateToLogin: () -> Unit,
) {
    navigation(startDestination = HOME_ROUTE, route = HOME_GRAPH_ROUTE) {
        homeScreen(
            onNavigateToProductBrowser = onNavigateToCategoryBrowser,
            onNavigateToProductCard = onNavigateToProductCard,
            onNavigateToLogin = onNavigateToLogin,
        )
    }
}
