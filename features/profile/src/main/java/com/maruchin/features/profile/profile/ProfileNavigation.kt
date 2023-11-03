package com.maruchin.features.profile.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.promotions.PromotionId

internal const val PROFILE_ROUTE = "profile"

internal fun NavGraphBuilder.profileScreen(
    onOpenSettings: () -> Unit,
    onOpenPurchaseHistory: () -> Unit,
    onOpenFindOutMore: () -> Unit,
    onOpenPromotion: (PromotionId) -> Unit
) {
    composable(PROFILE_ROUTE) {
        ProfileScreen(
            isLoggedIn = true,
            onOpenSettings = onOpenSettings,
            onOpenPurchaseHistory = onOpenPurchaseHistory,
            onOpenFindOutMore = onOpenFindOutMore,
            onOpenPromotion = onOpenPromotion,
        )
    }
}
