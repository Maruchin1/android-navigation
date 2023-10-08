package com.maruchin.features.productbrowser.categorylist

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.categories.Category

internal const val CATEGORY_LIST_ROUTE = "category-list"

internal fun NavGraphBuilder.categoryListScreen(onShowCategory: (Category) -> Unit) {
    composable(route = CATEGORY_LIST_ROUTE) {
        val viewModel: CategoryListViewModel = hiltViewModel()
        CategoryListScreen(
            categories = viewModel.categories,
            onShowCategory = onShowCategory
        )
    }
}