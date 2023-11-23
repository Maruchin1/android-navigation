package com.maruchin.features.favorites

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
import com.maruchin.ui.ROOT_DEEPLINK
import com.maruchin.ui.screenFadeIn
import com.maruchin.ui.screenFadeOut

const val FAVORITES_GRAPH_ROUTE = "favorites-graph"
private const val FAVORITES_DEEPLINK = "$ROOT_DEEPLINK/favorites"

fun NavGraphBuilder.favoritesGraph(onProductClick: (productId: String) -> Unit) {
    navigation(
        startDestination = FAVORITES_ROUTE,
        route = FAVORITES_GRAPH_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = FAVORITES_DEEPLINK }
        ),
        enterTransition = { screenFadeIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenFadeOut() },
    ) {
        favoritesScreen(
            onProductClick = onProductClick
        )
    }
}
