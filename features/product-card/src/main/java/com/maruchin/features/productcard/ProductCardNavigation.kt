package com.maruchin.features.productcard

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val PRODUCT_CARD = "product-card"

internal fun NavGraphBuilder.productCardScreen(onBack: () -> Unit) {
    composable(PRODUCT_CARD) {
        ProductCardScreen(onBack = onBack)
    }
}
