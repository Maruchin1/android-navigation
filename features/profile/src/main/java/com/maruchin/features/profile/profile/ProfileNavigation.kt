package com.maruchin.features.profile.profile

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.core.ui.screenFadeIn
import com.maruchin.core.ui.screenFadeOut

internal const val PROFILE_ROUTE = "profile"

internal fun NavGraphBuilder.profileScreen(
    onOpenPurchaseHistory: () -> Unit,
    onOpenFindOutMore: () -> Unit,
    onOpenPromotion: (promotionId: String) -> Unit,
    onOpenMyData: () -> Unit,
    onOpenMyOrders: () -> Unit,
    onOpenReturns: () -> Unit,
    onNavigateToLogin: () -> Unit,
    onNavigateToJoinClub: () -> Unit
) {
    composable(
        route = PROFILE_ROUTE,
        enterTransition = { screenFadeIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenFadeOut() },
    ) {
        val viewModel: ProfileViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        ProfileScreen(
            state = state,
            onOpenPurchaseHistory = onOpenPurchaseHistory,
            onOpenFindOutMore = onOpenFindOutMore,
            onOpenPromotion = onOpenPromotion,
            onOpenMyData = onOpenMyData,
            onOpenMyOrders = onOpenMyOrders,
            onOpenReturns = onOpenReturns,
            onNavigateToLogin = onNavigateToLogin,
            onNavigateToJoinClub = onNavigateToJoinClub,
        )
    }
}
