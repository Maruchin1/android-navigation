package com.maruchin.features.productcard

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.maruchin.features.productcard.card.CARD_ROUTE
import com.maruchin.features.productcard.card.cardScreen
import com.maruchin.features.productcard.gallery.galleryScreen
import com.maruchin.features.productcard.gallery.navigateToGallery

private const val PRODUCT_ID_ARG = "productId"
const val PRODUCT_CARD_GRAPH_ROUTE = "product-card-graph/{$PRODUCT_ID_ARG}"

internal data class ProductCardArgs(val productId: Int) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        productId = requireNotNull(savedStateHandle[PRODUCT_ID_ARG])
    )
}

fun NavGraphBuilder.productCardGraph(navController: NavController, parent: String) {
    navigation(
        startDestination = CARD_ROUTE,
        route = "$parent/$PRODUCT_CARD_GRAPH_ROUTE",
        arguments = listOf(
            navArgument(PRODUCT_ID_ARG) { type = NavType.IntType }
        )
    ) {
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

fun NavController.navigateToProductCardGraph(parent: String, productId: Int) {
    navigate("$parent/$PRODUCT_CARD_GRAPH_ROUTE".replace("{$PRODUCT_ID_ARG}", productId.toString()))
}