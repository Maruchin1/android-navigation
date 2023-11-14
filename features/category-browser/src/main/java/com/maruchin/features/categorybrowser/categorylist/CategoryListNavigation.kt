package com.maruchin.features.categorybrowser.categorylist

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.core.ui.screenFadeIn
import com.maruchin.core.ui.screenFadeOut
import com.maruchin.data.categories.CategoryId

internal const val CATEGORY_LIST_ROUTE = "category-list"

internal fun NavGraphBuilder.categoryListScreen(
    onNavigateToSubcategoryList: (CategoryId) -> Unit,
    onNavigateToProductBrowser: (CategoryId) -> Unit,
) {
    composable(
        route = CATEGORY_LIST_ROUTE,
        enterTransition = { screenFadeIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenFadeOut() },
    ) {
        val viewModel: CategoryListViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        CategoryListScreen(
            state = state,
            onCategoryClick = { categoryId, isFinal ->
                if (isFinal) {
                    onNavigateToProductBrowser(categoryId)
                } else {
                    onNavigateToSubcategoryList(categoryId)
                }
            },
        )
    }
}
