package com.maruchin.features.cart.cart

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.core.ui.screenFadeIn
import com.maruchin.core.ui.screenFadeOut
import com.maruchin.data.products.ProductId

internal const val CART_ROUTE = "cart"

internal fun NavGraphBuilder.cartScreen(
    onNavigateToOrder: () -> Unit,
    onNavigateToProduct: (ProductId) -> Unit,
) {
    composable(
        route = CART_ROUTE,
        enterTransition = { screenFadeIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenFadeOut() },
    ) {
        val viewModel: CartViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        CartScreen(
            state = state,
            onNextClick = onNavigateToOrder,
            onProductClick = onNavigateToProduct,
        )
    }
}
