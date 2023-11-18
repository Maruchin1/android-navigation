package com.maruchin.features.categorybrowser.subcategorylist

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val CATEGORY_ID = "categoryId"
internal const val SUBCATEGORY_LIST_ROUTE = "subcategory-list/{$CATEGORY_ID}"

internal data class SubcategoryListArgs(val categoryId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        categoryId = checkNotNull(savedStateHandle[CATEGORY_ID])
    )
}

internal fun NavController.navigateToSubcategoryList(categoryId: String) {
    navigate(SUBCATEGORY_LIST_ROUTE.replace("{$CATEGORY_ID}", categoryId))
}

internal fun NavGraphBuilder.subcategoryListScreen(
    onBackClick: () -> Unit,
    onCategoryClick: (categoryId: String, isFinal: Boolean) -> Unit
) {
    composable(SUBCATEGORY_LIST_ROUTE) {
        val viewModel: SubcategoryListViewModel = hiltViewModel()
        val category by viewModel.category.collectAsState()

        SubcategoryListScreen(
            category = category,
            onBackClick = onBackClick,
            onCategoryClick = onCategoryClick,
        )
    }
}
