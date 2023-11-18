package com.maruchin.features.productbrowser

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.maruchin.features.productbrowser.filters.filtersScreen
import com.maruchin.features.productbrowser.filters.navigateToFilters
import com.maruchin.features.productbrowser.productlist.PRODUCT_LIST_ROUTE
import com.maruchin.features.productbrowser.productlist.productListScreen

private const val CATEGORY_ID = "categoryId"
const val PRODUCT_BROWSER_GRAPH_ROUTE = "product-browser-graph/{$CATEGORY_ID}"

internal data class ProductBrowserArgs(val categoryId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        categoryId = checkNotNull(savedStateHandle[CATEGORY_ID])
    )
}

fun NavGraphBuilder.productBrowserGraph(
    navController: NavController,
    onShowProduct: (productId: String) -> Unit
) {
    navigation(startDestination = PRODUCT_LIST_ROUTE, route = PRODUCT_BROWSER_GRAPH_ROUTE) {
        productListScreen(
            onBackClick = {
                navController.navigateUp()
            },
            onProductClick = onShowProduct,
            onFiltersClick = {
                navController.navigateToFilters()
            }
        )
        filtersScreen(
            onBackClick = {
                navController.navigateUp()
            }
        )
    }
}

fun NavController.navigateToProductBrowserGraph(categoryId: String) {
    val route = PRODUCT_BROWSER_GRAPH_ROUTE.replace("{$CATEGORY_ID}", categoryId)
    navigate(route)
}