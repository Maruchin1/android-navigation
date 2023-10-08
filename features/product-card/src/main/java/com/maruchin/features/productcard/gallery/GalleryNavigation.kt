package com.maruchin.features.productcard.gallery

import androidx.compose.runtime.collectAsState
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.dialog
import androidx.navigation.navArgument

private const val PRODUCT_ID_ARG = "productId"
private const val GALLERY_ROUTE = "gallery/{$PRODUCT_ID_ARG}"

internal data class GalleryArgs(val productId: Int) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        productId = requireNotNull(savedStateHandle[PRODUCT_ID_ARG])
    )
}

internal fun NavGraphBuilder.galleryScreen(onBack: () -> Unit) {
    dialog(
        route = GALLERY_ROUTE,
        arguments = listOf(
            navArgument(PRODUCT_ID_ARG) { type = NavType.IntType }
        ),
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: GalleryViewModel = hiltViewModel()
        GalleryScreen(
            images = viewModel.images.collectAsState().value,
            onBack = onBack
        )
    }
}

internal fun NavController.navigateToGallery(productId: Int) {
    navigate(GALLERY_ROUTE.replace("{$PRODUCT_ID_ARG}", productId.toString()))
}