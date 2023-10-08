package com.maruchin.features.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.data.categories.Category
import com.maruchin.data.products.Product

const val HOME_GRAPH_ROUTE = "home-graph"

fun NavGraphBuilder.homeGraph(
    navController: NavController,
    onShowProductsFromCategory: (Category) -> Unit,
    onShowProduct: (Product) -> Unit
) {
    navigation(startDestination = HOME_ROUTE, route = HOME_GRAPH_ROUTE) {
        homeScreen(
            onShowProductsFromCategory = onShowProductsFromCategory,
            onShowProduct = onShowProduct,
        )
    }
}
