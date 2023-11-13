package com.maruchin.features.productcard.card

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.products.Product

internal const val CARD_ROUTE = "card"

internal fun NavGraphBuilder.cardScreen(
    onBack: () -> Unit,
    onOpenGallery: (Product) -> Unit
) {
    composable(CARD_ROUTE) {
        val viewModel: CardViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        CardScreen(
            state = state,
            onBack = onBack,
            onOpenGallery = {
                state.product?.let(onOpenGallery)
            },
            onAddToCart = viewModel::addToCart,
        )
    }
}
