package com.maruchin.features.cart

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
import com.maruchin.ui.ROOT_DEEPLINK
import com.maruchin.ui.screenFadeIn
import com.maruchin.ui.screenFadeOut

const val CART_GRAPH_ROUTE = "cart-graph"
private const val CART_DEEPLINK = "$ROOT_DEEPLINK/cart"

fun NavGraphBuilder.cartGraph(
    onNextClick: () -> Unit,
    onProductClick: (product: String) -> Unit,
) {
    navigation(
        startDestination = CART_ROUTE,
        route = CART_GRAPH_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = CART_DEEPLINK }
        ),
        enterTransition = { screenFadeIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenFadeOut() },
    ) {
        cartScreen(
            onNextClick = onNextClick,
            onProductClick = onProductClick,
        )
    }
}
