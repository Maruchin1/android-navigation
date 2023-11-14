package com.maruchin.features.home

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.maruchin.core.ui.ROOT_DEEPLINK
import com.maruchin.core.ui.screenFadeIn
import com.maruchin.core.ui.screenFadeOut
import com.maruchin.data.categories.CategoryId
import com.maruchin.data.products.ProductId

internal const val HOME_ROUTE = "home"
private const val HOME_DEEPLINK = "$ROOT_DEEPLINK/home"

internal fun NavGraphBuilder.homeScreen(
    onNavigateToProductBrowser: (CategoryId) -> Unit,
    onNavigateToProductCard: (ProductId) -> Unit,
    onNavigateToLogin: () -> Unit,
) {
    composable(
        route = HOME_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = HOME_DEEPLINK }
        ),
        enterTransition = { screenFadeIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenFadeOut() },
    ) {
        val viewModel: HomeViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        HomeScreen(
            state = state,
            onCategoryClick = onNavigateToProductBrowser,
            onProductClick = onNavigateToProductCard,
            onLoginClick = onNavigateToLogin,
        )
    }
}