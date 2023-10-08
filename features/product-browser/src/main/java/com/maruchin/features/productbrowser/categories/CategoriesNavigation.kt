package com.maruchin.features.productbrowser.categories

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.categories.Category

internal const val CATEGORIES = "categories"

internal fun NavGraphBuilder.categoriesScreen(onShowCategory: (Category) -> Unit) {
    composable(route = CATEGORIES) {
        CategoriesScreen(onShowCategory = onShowCategory)
    }
}