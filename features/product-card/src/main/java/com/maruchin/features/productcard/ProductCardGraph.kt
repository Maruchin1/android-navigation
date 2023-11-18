package com.maruchin.features.productcard

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.maruchin.features.productcard.card.CARD_ROUTE
import com.maruchin.features.productcard.card.cardScreen
import com.maruchin.features.productcard.gallery.galleryScreen
import com.maruchin.features.productcard.gallery.navigateToGallery

private const val PRODUCT_ID_ARG = "productId"
const val PRODUCT_CARD_GRAPH_ROUTE = "product-card-graph/{$PRODUCT_ID_ARG}"

internal data class ProductCardArgs(val productId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        productId = checkNotNull(savedStateHandle[PRODUCT_ID_ARG])
    )
}

fun NavGraphBuilder.productCardGraph(navController: NavController) {
    navigation(startDestination = CARD_ROUTE, route = PRODUCT_CARD_GRAPH_ROUTE) {
        cardScreen(
            onBackClick = {
                navController.navigateUp()
            },
            onGalleryClick = { productId ->
                navController.navigateToGallery(productId)
            }
        )
        galleryScreen(
            onBack = {
                navController.navigateUp()
            }
        )
    }
}

fun NavController.navigateToProductCardGraph(productId: String) {
    navigate(PRODUCT_CARD_GRAPH_ROUTE.replace("{$PRODUCT_ID_ARG}", productId))
}
