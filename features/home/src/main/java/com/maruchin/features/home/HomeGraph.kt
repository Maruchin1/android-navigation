package com.maruchin.features.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.data.categories.CategoryId
import com.maruchin.data.products.ProductId

const val HOME_GRAPH_ROUTE = "home-graph"

fun NavGraphBuilder.homeGraph(
    onNavigateToCategoryBrowser: (CategoryId) -> Unit,
    onNavigateToProductCard: (ProductId) -> Unit,
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
