package com.maruchin.features.home

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.core.ui.screenFadeIn
import com.maruchin.core.ui.screenFadeOut
import com.maruchin.data.categories.Category
import com.maruchin.data.products.Product

internal const val HOME_ROUTE = "home"

internal fun NavGraphBuilder.homeScreen(
    onShowProductsFromCategory: (Category) -> Unit,
    onShowProduct: (Product) -> Unit,
    onLogin: () -> Unit,
) {
    composable(
        route = HOME_ROUTE,
        enterTransition = { screenFadeIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenFadeOut() },
    ) {
        val viewModel: HomeViewModel = hiltViewModel()
        HomeScreen(
            products = viewModel.products.collectAsState().value,
            canLogin = viewModel.canLogin.collectAsState().value,
            onShowProductsFromCategory = onShowProductsFromCategory,
            onShowProduct = onShowProduct,
            onLogin = onLogin,
        )
    }
}