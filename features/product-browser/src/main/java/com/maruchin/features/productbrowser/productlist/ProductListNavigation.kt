package com.maruchin.features.productbrowser.productlist

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val PRODUCT_LIST_ROUTE = "product-list"

internal fun NavGraphBuilder.productListScreen(
    onBackClick: () -> Unit,
    onProductClick: (productId: String) -> Unit,
    onFiltersClick: () -> Unit,
) {
    composable(route = PRODUCT_LIST_ROUTE) {
        val viewModel: ProductListViewModel = hiltViewModel()
        val category by viewModel.category.collectAsState()
        val products by viewModel.products.collectAsState()

        ProductListScreen(
            category = category,
            products = products,
            onBackClick = onBackClick,
            onProductClick = onProductClick,
            onFiltersClick = onFiltersClick,
        )
    }
}
