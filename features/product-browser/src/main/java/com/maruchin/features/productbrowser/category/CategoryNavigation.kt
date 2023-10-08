package com.maruchin.features.productbrowser.category

import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.maruchin.data.products.Product

private const val CATEGORY_NAME_ARG = "categoryName"
private const val CATEGORY_ROUTE = "category/{$CATEGORY_NAME_ARG}"
private const val CATEGORY_DEEPLINK = "app://$CATEGORY_ROUTE"

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
        ),
        deepLinks = listOf(
            navDeepLink { uriPattern = CATEGORY_DEEPLINK }
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
    val route = CATEGORY_ROUTE.replace("{$CATEGORY_NAME_ARG}", categoryName)
    navigate(route)
}

fun NavController.deeplinkToCategory(categoryName: String) {
    val deeplink = CATEGORY_DEEPLINK.replace("{$CATEGORY_NAME_ARG}", categoryName)
    val request = NavDeepLinkRequest.Builder.fromUri(deeplink.toUri()).build()
    navigate(request)
}