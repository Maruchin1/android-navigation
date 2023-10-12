package com.maruchin.features.categorybrowser.subcategorylist

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.categories.Category
import com.maruchin.data.categories.CategoryId

private const val CATEGORY_ID = "categoryId"
private const val SUBCATEGORY_LIST_ROUTE = "subcategoryList/{$CATEGORY_ID}"

internal data class SubcategoryListArgs(val categoryId: CategoryId) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        categoryId = CategoryId(requireNotNull(savedStateHandle[CATEGORY_ID]))
    )
}

internal fun NavGraphBuilder.subcategoryListScreen(
    onBack: () -> Unit,
    onShowCategory: (Category) -> Unit,
) {
    composable(SUBCATEGORY_LIST_ROUTE) {
        val viewModel: SubcategoryListViewModel = hiltViewModel()
        SubcategoryListScreen(
            category = viewModel.category.collectAsState().value,
            onBack = onBack,
            onShowCategory = onShowCategory
        )
    }
}

internal fun NavController.navigateToSubcategoryList(categoryId: CategoryId) {
    navigate(SUBCATEGORY_LIST_ROUTE.replace("{$CATEGORY_ID}", categoryId.value))
}
