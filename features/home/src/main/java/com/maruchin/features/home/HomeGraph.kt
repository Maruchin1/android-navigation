package com.maruchin.features.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

const val HOME_GRAPH_ROUTE = "home-graph"

fun NavGraphBuilder.homeGraph(
    onCategoryClick: (categoryId: String) -> Unit,
    onProductClick: (productId: String) -> Unit,
    onLoginClick: () -> Unit,
) {
    navigation(startDestination = HOME_ROUTE, route = HOME_GRAPH_ROUTE) {
        homeScreen(
            onCategoryClick = onCategoryClick,
            onProductClick = onProductClick,
            onLoginClick = onLoginClick,
        )
    }
}
