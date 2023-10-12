package com.maruchin.features.productcard

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.maruchin.data.products.ProductId
import com.maruchin.features.productcard.card.CARD_ROUTE
import com.maruchin.features.productcard.card.cardScreen
import com.maruchin.features.productcard.gallery.galleryScreen
import com.maruchin.features.productcard.gallery.navigateToGallery

private const val PRODUCT_ID_ARG = "productId"
const val PRODUCT_CARD_GRAPH_ROUTE = "product-card-graph/{$PRODUCT_ID_ARG}"

internal data class ProductCardArgs(val productId: ProductId) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        productId = ProductId(requireNotNull(savedStateHandle[PRODUCT_ID_ARG]))
    )
}

fun NavGraphBuilder.productCardGraph(navController: NavController) {
    navigation(startDestination = CARD_ROUTE, route = PRODUCT_CARD_GRAPH_ROUTE) {
        cardScreen(
            onBack = {
                navController.navigateUp()
            },
            onOpenGallery = {
                navController.navigateToGallery(it.id)
            }
        )
        galleryScreen(
            onBack = {
                navController.navigateUp()
            }
        )
    }
}

fun NavController.navigateToProductCardGraph(productId: ProductId) {
    navigate(PRODUCT_CARD_GRAPH_ROUTE.replace("{$PRODUCT_ID_ARG}", productId.value))
}