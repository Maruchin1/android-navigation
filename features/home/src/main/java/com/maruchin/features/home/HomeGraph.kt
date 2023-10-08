package com.maruchin.features.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.features.productcard.productCardGraph
import com.maruchin.features.productcard.toProductCardGraph

const val HOME_GRAPH = "home-graph"

fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation(startDestination = HOME, route = HOME_GRAPH) {
        homeScreen(
            onShowAllFromCategory = {},
            onShowProduct = { product ->
                navController.toProductCardGraph(product.id)
            }
        )
        productCardGraph(navController)
    }
}
