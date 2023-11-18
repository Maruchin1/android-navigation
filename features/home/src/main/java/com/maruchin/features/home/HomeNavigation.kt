package com.maruchin.features.home

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.maruchin.ui.ROOT_DEEPLINK
import com.maruchin.ui.screenFadeIn
import com.maruchin.ui.screenFadeOut

internal const val HOME_ROUTE = "home"
private const val HOME_DEEPLINK = "$ROOT_DEEPLINK/home"

internal fun NavGraphBuilder.homeScreen(
    onCategoryClick: (categoryId: String) -> Unit,
    onProductClick: (productId: String) -> Unit,
    onLoginClick: () -> Unit,
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
        val categories by viewModel.categories.collectAsState()
        val canLogin by viewModel.canLogin.collectAsState()

        HomeScreen(
            categories = categories,
            canLogin = canLogin,
            onCategoryClick = onCategoryClick,
            onProductClick = onProductClick,
            onLoginClick = onLoginClick,
        )
    }
}