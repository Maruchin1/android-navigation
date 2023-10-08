package com.maruchin.features.productcard.card

import androidx.compose.runtime.collectAsState
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
        CardScreen(
            product = viewModel.product.collectAsState().value,
            onBack = onBack,
            onOpenGallery = {
                viewModel.product.value?.let(onOpenGallery)
            },
        )
    }
}
