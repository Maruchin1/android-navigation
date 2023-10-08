package com.maruchin.features.productcard.card

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.products.Product

internal const val CARD = "card"

internal fun NavGraphBuilder.cardScreen(
    onBack: () -> Unit,
    onOpenGallery: (Product) -> Unit
) {
    composable(CARD) {
        CardScreen(onBack = onBack, onOpenGallery = onOpenGallery)
    }
}
