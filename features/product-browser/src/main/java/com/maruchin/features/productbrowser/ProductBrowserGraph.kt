package com.maruchin.features.productbrowser

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.maruchin.data.products.Product
import com.maruchin.features.productbrowser.filters.filtersScreen
import com.maruchin.features.productbrowser.filters.navigateToFilters
import com.maruchin.features.productbrowser.productlist.PRODUCT_LIST_ROUTE
import com.maruchin.features.productbrowser.productlist.productListScreen

private const val CATEGORY_NAME = "categoryName"
const val PRODUCT_BROWSER_GRAPH_ROUTE = "product-browser-graph/{$CATEGORY_NAME}"

internal data class ProductBrowserArgs(val categoryName: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        categoryName = requireNotNull(savedStateHandle[CATEGORY_NAME])
    )
}

fun NavGraphBuilder.productBrowserGraph(
    navController: NavController,
    onShowProduct: (Product) -> Unit
) {
    navigation(
        startDestination = PRODUCT_LIST_ROUTE,
        route = PRODUCT_BROWSER_GRAPH_ROUTE,
        arguments = listOf(
            navArgument(CATEGORY_NAME) { type = NavType.StringType }
        )
    ) {
        productListScreen(
            onBack = {
                navController.navigateUp()
            },
            onShowProduct = onShowProduct,
            onShowFilters = {
                navController.navigateToFilters()
            }
        )
        filtersScreen(
            onBack = {
                navController.navigateUp()
            }
        )
    }
}

fun NavController.navigateToProductBrowserGraph(categoryName: String) {
    val route = PRODUCT_BROWSER_GRAPH_ROUTE.replace("{$CATEGORY_NAME}", categoryName)
    navigate(route)
}