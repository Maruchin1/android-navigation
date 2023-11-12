package com.maruchin.features.profile.returns

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val RETURNS_ROUTE = "returns"

internal fun NavGraphBuilder.returnsScreen(onBack: () -> Unit, onNavigateToReturnsForm: () -> Unit) {
    composable(RETURNS_ROUTE) {
        ReturnsScreen(onBack = onBack, onNavigateToReturnsForm = onNavigateToReturnsForm)
    }
}

internal fun NavController.navigateToReturns() {
    navigate(RETURNS_ROUTE)
}
