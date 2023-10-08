package com.maruchin.features.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.categories.Category
import com.maruchin.data.products.Product

internal const val HOME = "home"

internal fun NavGraphBuilder.homeScreen(
    onShowAllFromCategory: (Category) -> Unit,
    onShowProduct: (Product) -> Unit
) {
    composable(HOME) {
        HomeScreen(onShowAllFromCategory = onShowAllFromCategory, onShowProduct = onShowProduct)
    }
}