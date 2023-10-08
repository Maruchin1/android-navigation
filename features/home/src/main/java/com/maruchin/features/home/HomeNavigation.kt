package com.maruchin.features.home

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.categories.Category
import com.maruchin.data.products.Product

internal const val HOME_ROUTE = "home"

internal fun NavGraphBuilder.homeScreen(
    onShowProductsFromCategory: (Category) -> Unit,
    onShowProduct: (Product) -> Unit
) {
    composable(HOME_ROUTE) {
        val viewModel: HomeViewModel = hiltViewModel()
        HomeScreen(
            products = viewModel.products.collectAsState().value,
            onShowProductsFromCategory = onShowProductsFromCategory,
            onShowProduct = onShowProduct,
        )
    }
}