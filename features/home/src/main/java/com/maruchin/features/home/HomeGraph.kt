package com.maruchin.features.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
import com.maruchin.ui.ROOT_DEEPLINK
import com.maruchin.ui.screenFadeIn
import com.maruchin.ui.screenFadeOut

const val HOME_GRAPH_ROUTE = "home-graph"
private const val HOME_DEEPLINK = "$ROOT_DEEPLINK/home"

fun NavGraphBuilder.homeGraph(
    onCategoryClick: (categoryId: String) -> Unit,
    onProductClick: (productId: String) -> Unit,
    onLoginClick: () -> Unit,
) {
    navigation(
        startDestination = HOME_ROUTE,
        route = HOME_GRAPH_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = HOME_DEEPLINK }
        ),
        enterTransition = { screenFadeIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenFadeOut() },
    ) {
        homeScreen(
            onCategoryClick = onCategoryClick,
            onProductClick = onProductClick,
            onLoginClick = onLoginClick,
        )
    }
}
