package com.maruchin.features.favorites

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val FAVORITES_ROUTE = "favorites"

internal fun NavGraphBuilder.favoritesScreen(onProductClick: (productId: String) -> Unit) {
    composable(route = FAVORITES_ROUTE) {
        val viewModel: FavoritesViewModel = hiltViewModel()
        val products by viewModel.products.collectAsState()

        FavoritesScreen(products = products, onProductClick = onProductClick)
    }
}
