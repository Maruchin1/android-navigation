package com.maruchin.features.cart

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.maruchin.core.ui.ROOT_DEEPLINK
import com.maruchin.core.ui.screenFadeIn
import com.maruchin.core.ui.screenFadeOut

internal const val CART_ROUTE = "cart"
private const val CART_DEEPLINK = "$ROOT_DEEPLINK/cart"

internal fun NavGraphBuilder.cartScreen(
    onNavigateToOrder: () -> Unit,
    onNavigateToProductCard: (productId: String) -> Unit,
) {
    composable(
        route = CART_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = CART_DEEPLINK }
        ),
        enterTransition = { screenFadeIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenFadeOut() },
    ) {
        val viewModel: CartViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        CartScreen(
            state = state,
            onNextClick = {
                viewModel.createNewOrder()
                onNavigateToOrder()
            },
            onProductClick = onNavigateToProductCard,
        )
    }
}
