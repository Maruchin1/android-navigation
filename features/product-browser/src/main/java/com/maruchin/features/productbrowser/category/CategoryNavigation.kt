package com.maruchin.features.productbrowser.category

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.products.Product
import com.maruchin.features.productbrowser.CATEGORY_NAME

internal const val CATEGORY = "category/{$CATEGORY_NAME}"

internal fun NavGraphBuilder.categoryScreen(onBack: () -> Unit, onShowProduct: (Product) -> Unit) {
    composable(route = CATEGORY) {
        CategoryScreen(onBack = onBack, onShowProduct = onShowProduct)
    }
}

internal fun NavController.toCategory(categoryName: String) {
    navigate(route = CATEGORY.replace("{$CATEGORY_NAME}", categoryName))
}