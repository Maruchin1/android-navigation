package com.maruchin.features.categorybrowser.categorylist

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.ui.screenFadeIn
import com.maruchin.ui.screenFadeOut

internal const val CATEGORY_LIST_ROUTE = "category-list"

internal fun NavGraphBuilder.categoryListScreen(
    onCategoryClick: (categoryId: String, isFinal: Boolean) -> Unit,
) {
    composable(
        route = CATEGORY_LIST_ROUTE,
        enterTransition = { screenFadeIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenFadeOut() },
    ) {
        val viewModel: CategoryListViewModel = hiltViewModel()
        val categories by viewModel.categories.collectAsState()

        CategoryListScreen(
            categories = categories,
            onCategoryClick = onCategoryClick,
        )
    }
}
