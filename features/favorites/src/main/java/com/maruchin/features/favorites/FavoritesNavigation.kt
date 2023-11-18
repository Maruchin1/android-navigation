package com.maruchin.features.favorites

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.maruchin.ui.ROOT_DEEPLINK
import com.maruchin.ui.screenFadeIn
import com.maruchin.ui.screenFadeOut

internal const val FAVORITES_ROUTE = "favorites"
private const val FAVORITES_DEEPLINK = "$ROOT_DEEPLINK/favorites"

internal fun NavGraphBuilder.favoritesScreen(onProductClick: (productId: String) -> Unit) {
    composable(
        route = FAVORITES_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = FAVORITES_DEEPLINK }
        ),
        enterTransition = { screenFadeIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenFadeOut() },
    ) {
        val viewModel: FavoritesViewModel = hiltViewModel()
        val products by viewModel.products.collectAsState()

        FavoritesScreen(products = products, onProductClick = onProductClick)
    }
}
