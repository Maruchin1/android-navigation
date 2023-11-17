package com.maruchin.features.productbrowser.productlist

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val PRODUCT_LIST_ROUTE = "product-list"

internal fun NavGraphBuilder.productListScreen(
    onBack: () -> Unit,
    onShowProduct: (productId: String) -> Unit,
    onShowFilters: () -> Unit,
) {
    composable(route = PRODUCT_LIST_ROUTE) {
        val viewModel: ProductListViewModel = hiltViewModel()
        ProductListScreen(
            category = viewModel.category.collectAsState().value,
            products = viewModel.products.collectAsState().value,
            onBack = onBack,
            onShowProduct = onShowProduct,
            onShowFilters = onShowFilters,
        )
    }
}
