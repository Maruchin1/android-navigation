package com.maruchin.features.productbrowser.category

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.maruchin.data.products.Product

private const val CATEGORY_NAME_ARG = "categoryName"
private const val CATEGORY_ROUTE = "category/{$CATEGORY_NAME_ARG}"

internal data class CategoryArgs(val categoryName: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        categoryName = requireNotNull(savedStateHandle[CATEGORY_NAME_ARG])
    )
}

internal fun NavGraphBuilder.categoryScreen(onBack: () -> Unit, onShowProduct: (Product) -> Unit) {
    composable(
        route = CATEGORY_ROUTE,
        arguments = listOf(
            navArgument(CATEGORY_NAME_ARG) { type = NavType.StringType }
        )
    ) {
        val viewModel: CategoryViewModel = hiltViewModel()
        CategoryScreen(
            category = viewModel.category,
            products = viewModel.products,
            onBack = onBack,
            onShowProduct = onShowProduct,
        )
    }
}

internal fun NavController.navigateToCategory(categoryName: String) {
    navigate(route = CATEGORY_ROUTE.replace("{$CATEGORY_NAME_ARG}", categoryName))
}