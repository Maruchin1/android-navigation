package com.maruchin.features.productbrowser

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.maruchin.features.productbrowser.categorylist.CATEGORY_LIST_ROUTE
import com.maruchin.features.productbrowser.categorylist.categoryListScreen
import com.maruchin.features.productbrowser.category.categoryScreen
import com.maruchin.features.productbrowser.category.navigateToCategory
import com.maruchin.features.productcard.productCardGraph
import com.maruchin.features.productcard.navigateToProductCardGraph

const val PRODUCT_BROWSER_GRAPH_ROUTE = "product-browser-graph"

fun NavGraphBuilder.productBrowserGraph(navController: NavController) {
    navigation(
        startDestination = CATEGORY_LIST_ROUTE,
        route = PRODUCT_BROWSER_GRAPH_ROUTE,
    ) {
        categoryListScreen(
            onShowCategory = {
                navController.navigateToCategory(it.name)
            }
        )
        categoryScreen(
            onBack = {
                navController.navigateUp()
            },
            onShowProduct = { product ->
                navController.navigateToProductCardGraph(
                    parent = PRODUCT_BROWSER_GRAPH_ROUTE,
                    productId = product.id
                )
            }
        )
        productCardGraph(navController, parent = PRODUCT_BROWSER_GRAPH_ROUTE)
    }
}