package com.maruchin.features.productcard

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.maruchin.features.productcard.card.CARD
import com.maruchin.features.productcard.card.cardScreen
import com.maruchin.features.productcard.gallery.galleryScreen
import com.maruchin.features.productcard.gallery.toGallery

internal const val PRODUCT_ID = "productId"
const val PRODUCT_CARD_GRAPH = "product-card-graph/{$PRODUCT_ID}"

fun NavGraphBuilder.productCardGraph(navController: NavController) {
    navigation(
        startDestination = CARD,
        route = PRODUCT_CARD_GRAPH,
        arguments = listOf(
            navArgument(PRODUCT_ID) { type = NavType.IntType }
        )
    ) {
        cardScreen(
            onBack = { navController.navigateUp() },
            onOpenGallery = { navController.toGallery(it.id) }
        )
        galleryScreen(
            onBack = { navController.navigateUp() }
        )
    }
}

fun NavController.toProductCardGraph(productId: Int) {
    navigate(PRODUCT_CARD_GRAPH.replace("{$PRODUCT_ID}", productId.toString()))
}