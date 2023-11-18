package com.maruchin.features.profile.findoutmore

import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog

internal const val FIND_OUT_MORE_ROUTE = "find-out-more"

internal fun NavController.navigateToFindOutMore() {
    navigate(FIND_OUT_MORE_ROUTE)
}

internal fun NavGraphBuilder.findOutMoreScreen(onCloseClick: () -> Unit) {
    dialog(
        route = FIND_OUT_MORE_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        FindOutMoreScreen(onCloseClick = onCloseClick)
    }
}
