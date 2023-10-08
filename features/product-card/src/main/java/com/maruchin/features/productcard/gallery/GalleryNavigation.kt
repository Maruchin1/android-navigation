package com.maruchin.features.productcard.gallery

import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.dialog
import androidx.navigation.navArgument
import com.maruchin.features.productcard.PRODUCT_ID

internal const val GALLERY = "gallery/{$PRODUCT_ID}"

internal fun NavGraphBuilder.galleryScreen(onBack: () -> Unit) {
    dialog(
        route = GALLERY,
        arguments = listOf(
            navArgument(PRODUCT_ID) { type = NavType.IntType }
        ),
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        GalleryScreen(onBack = onBack)
    }
}

internal fun NavController.toGallery(productId: Int) {
    navigate(GALLERY.replace("{$PRODUCT_ID}", productId.toString()))
}