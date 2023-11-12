package com.maruchin.features.profile.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.core.ui.screenFadeIn
import com.maruchin.core.ui.screenFadeOut
import com.maruchin.data.promotions.PromotionId

internal const val PROFILE_ROUTE = "profile"

internal fun NavGraphBuilder.profileScreen(
    onOpenSettings: () -> Unit,
    onOpenPurchaseHistory: () -> Unit,
    onOpenFindOutMore: () -> Unit,
    onOpenPromotion: (PromotionId) -> Unit,
    onOpenMyData: () -> Unit,
    onOpenMyOrders: () -> Unit,
    onOpenReturns: () -> Unit,
) {
    composable(
        route = PROFILE_ROUTE,
        enterTransition = { screenFadeIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenFadeOut() },
    ) {
        ProfileScreen(
            isLoggedIn = true,
            onOpenSettings = onOpenSettings,
            onOpenPurchaseHistory = onOpenPurchaseHistory,
            onOpenFindOutMore = onOpenFindOutMore,
            onOpenPromotion = onOpenPromotion,
            onOpenMyData = onOpenMyData,
            onOpenMyOrders = onOpenMyOrders,
            onOpenReturns = onOpenReturns,
        )
    }
}
