package com.maruchin.features.productcard.card

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val CARD_ROUTE = "card"

internal fun NavGraphBuilder.cardScreen(
    onBackClick: () -> Unit,
    onGalleryClick: (productId: String) -> Unit
) {
    composable(CARD_ROUTE) {
        val viewModel: CardViewModel = hiltViewModel()
        val product by viewModel.product.collectAsState()

        CardScreen(
            product = product,
            onBackClick = onBackClick,
            onGalleryClick = {
                product?.id?.let(onGalleryClick)
            },
            onAddToCartClick = viewModel::addToCart,
            onFavoriteClick = viewModel::toggleIsFavorite,
        )
    }
}
