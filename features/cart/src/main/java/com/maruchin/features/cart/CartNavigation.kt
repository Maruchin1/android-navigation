package com.maruchin.features.cart

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val CART_ROUTE = "cart"

internal fun NavGraphBuilder.cartScreen(
    onNextClick: () -> Unit,
    onProductClick: (productId: String) -> Unit,
) {
    composable(route = CART_ROUTE) {
        val viewModel: CartViewModel = hiltViewModel()
        val cart by viewModel.cart.collectAsState()

        CartScreen(
            cart = cart,
            onNextClick = {
                viewModel.createNewOrder()
                onNextClick()
            },
            onProductClick = onProductClick,
        )
    }
}
