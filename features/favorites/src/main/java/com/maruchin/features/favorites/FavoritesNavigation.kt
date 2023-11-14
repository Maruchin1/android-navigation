package com.maruchin.features.favorites

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.products.Product

internal const val FAVORITES_ROUTE = "favorites"

internal fun NavGraphBuilder.favoritesScreen(onNavigateToProductCard: (Product) -> Unit) {
    composable(FAVORITES_ROUTE) {
        val viewModel: FavoritesViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        FavoritesScreen(state = state, onProductClick = onNavigateToProductCard)
    }
}
