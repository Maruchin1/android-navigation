package com.maruchin.features.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.data.categories.Category
import com.maruchin.features.productcard.productCardGraph
import com.maruchin.features.productcard.navigateToProductCardGraph

const val HOME_GRAPH_ROUTE = "home-graph"

fun NavGraphBuilder.homeGraph(
    navController: NavController,
    onShowAllFromCategory: (Category) -> Unit
) {
    navigation(startDestination = HOME_ROUTE, route = HOME_GRAPH_ROUTE) {
        homeScreen(
            onShowAllFromCategory = onShowAllFromCategory,
            onShowProduct = { product ->
                navController.navigateToProductCardGraph(
                    parent = HOME_GRAPH_ROUTE,
                    productId = product.id
                )
            }
        )
        productCardGraph(navController, parent = HOME_GRAPH_ROUTE)
    }
}
