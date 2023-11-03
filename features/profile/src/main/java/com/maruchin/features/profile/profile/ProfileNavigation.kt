package com.maruchin.features.profile.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val PROFILE_ROUTE = "profile"

internal fun NavGraphBuilder.profileScreen(
    onOpenSettings: () -> Unit,
    onOpenPurchaseHistory: () -> Unit,
    onOpenFindOutMore: () -> Unit,
) {
    composable(PROFILE_ROUTE) {
        ProfileScreen(
            isLoggedIn = true,
            onOpenSettings = onOpenSettings,
            onOpenPurchaseHistory = onOpenPurchaseHistory,
            onOpenFindOutMore = onOpenFindOutMore,
        )
    }
}
