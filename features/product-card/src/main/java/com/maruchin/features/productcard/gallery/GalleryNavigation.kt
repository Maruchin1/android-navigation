package com.maruchin.features.productcard.gallery

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog

private const val PRODUCT_ID_ARG = "productId"
private const val GALLERY_ROUTE = "gallery/{$PRODUCT_ID_ARG}"

internal data class GalleryArgs(val productId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        productId = checkNotNull(savedStateHandle[PRODUCT_ID_ARG])
    )
}

internal fun NavGraphBuilder.galleryScreen(onBack: () -> Unit) {
    dialog(
        route = GALLERY_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: GalleryViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        GalleryScreen(state = state, onBack = onBack)
    }
}

internal fun NavController.navigateToGallery(productId: String) {
    navigate(GALLERY_ROUTE.replace("{$PRODUCT_ID_ARG}", productId))
}