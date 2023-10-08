package com.maruchin.features.categorybrowser.categorylist

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.categories.Category

internal const val CATEGORY_LIST_ROUTE = "category-list"

internal fun NavGraphBuilder.categoryListScreen(onShowCategory: (Category) -> Unit) {
    composable(route = CATEGORY_LIST_ROUTE) {
        val viewModel: CategoryListViewModel = hiltViewModel()
        CategoryListScreen(
            categories = viewModel.categories.collectAsState().value,
            onShowCategory = onShowCategory,
        )
    }
}