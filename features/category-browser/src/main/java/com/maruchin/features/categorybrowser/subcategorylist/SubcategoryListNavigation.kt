package com.maruchin.features.categorybrowser.subcategorylist

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.categories.CategoryId

private const val CATEGORY_ID = "categoryId"
internal const val SUBCATEGORY_LIST_ROUTE = "subcategory-list/{$CATEGORY_ID}"

internal data class SubcategoryListArgs(val categoryId: CategoryId) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        categoryId = CategoryId(requireNotNull(savedStateHandle[CATEGORY_ID]))
    )
}

internal fun NavController.navigateToSubcategoryList(categoryId: CategoryId) {
    navigate(SUBCATEGORY_LIST_ROUTE.replace("{$CATEGORY_ID}", categoryId.value))
}

internal fun NavGraphBuilder.subcategoryListScreen(
    onNavigateBack: () -> Unit,
    onNavigateToSubcategoryList: (CategoryId) -> Unit,
    onNavigateToProductBrowser: (CategoryId) -> Unit,
) {
    composable(SUBCATEGORY_LIST_ROUTE) {
        val viewModel: SubcategoryListViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        SubcategoryListScreen(
            state = state,
            onBackClick = onNavigateBack,
            onCategoryClick = { categoryId, isFinal ->
                if (isFinal) {
                    onNavigateToProductBrowser(categoryId)
                } else {
                    onNavigateToSubcategoryList(categoryId)
                }
            }
        )
    }
}
