package com.maruchin.features.productbrowser

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.maruchin.features.productbrowser.categories.CATEGORIES
import com.maruchin.features.productbrowser.categories.categoriesScreen
import com.maruchin.features.productbrowser.category.categoryScreen
import com.maruchin.features.productbrowser.category.toCategory
import com.maruchin.features.productcard.productCardGraph
import com.maruchin.features.productcard.toProductCardGraph

const val CATEGORY_NAME = "categoryName"
const val PRODUCT_BROWSER_GRAPH = "product-browser-graph"

fun NavGraphBuilder.productBrowserGraph(navController: NavController) {
    navigation(
        startDestination = CATEGORIES,
        route = PRODUCT_BROWSER_GRAPH,
    ) {
        categoriesScreen(
            onShowCategory = {
                navController.toCategory(it.name)
            }
        )
        categoryScreen(
            onBack = {
                navController.navigateUp()
            },
            onShowProduct = { product ->
                navController.toProductCardGraph(
                    parent = PRODUCT_BROWSER_GRAPH,
                    productId = product.id
                )
            }
        )
        productCardGraph(navController, parent = PRODUCT_BROWSER_GRAPH)
    }
}