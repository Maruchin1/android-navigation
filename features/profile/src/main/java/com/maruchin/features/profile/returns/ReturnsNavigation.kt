package com.maruchin.features.profile.returns

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val RETURNS_ROUTE = "returns"

internal fun NavController.navigateToReturns() {
    navigate(RETURNS_ROUTE)
}

internal fun NavGraphBuilder.returnsScreen(onBackClick: () -> Unit, onGoToFormClick: () -> Unit) {
    composable(RETURNS_ROUTE) {
        ReturnsScreen(onBackClick = onBackClick, onGoToFormClick = onGoToFormClick)
    }
}
