package com.maruchin.features.productbrowser

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.maruchin.data.categories.CategoryId
import com.maruchin.data.products.Product
import com.maruchin.features.productbrowser.filters.filtersScreen
import com.maruchin.features.productbrowser.filters.navigateToFilters
import com.maruchin.features.productbrowser.productlist.PRODUCT_LIST_ROUTE
import com.maruchin.features.productbrowser.productlist.productListScreen

private const val CATEGORY_ID = "categoryName"
const val PRODUCT_BROWSER_GRAPH_ROUTE = "product-browser-graph/{$CATEGORY_ID}"

internal data class ProductBrowserArgs(val categoryId: CategoryId) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        categoryId = CategoryId(requireNotNull(savedStateHandle[CATEGORY_ID]))
    )
}

fun NavGraphBuilder.productBrowserGraph(
    navController: NavController,
    onShowProduct: (Product) -> Unit
) {
    navigation(startDestination = PRODUCT_LIST_ROUTE, route = PRODUCT_BROWSER_GRAPH_ROUTE) {
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
    val route = PRODUCT_BROWSER_GRAPH_ROUTE.replace("{$CATEGORY_ID}", categoryName)
    navigate(route)
}