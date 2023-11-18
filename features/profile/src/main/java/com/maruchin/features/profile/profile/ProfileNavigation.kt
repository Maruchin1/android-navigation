package com.maruchin.features.profile.profile

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.ui.screenFadeIn
import com.maruchin.ui.screenFadeOut

internal const val PROFILE_ROUTE = "profile"

internal fun NavGraphBuilder.profileScreen(
    onPurchaseHistoryClick: () -> Unit,
    onFindOutMoreClick: () -> Unit,
    onPromotionClick: (promotionId: String) -> Unit,
    onMyDataClick: () -> Unit,
    onMyOrdersClick: () -> Unit,
    onReturnsClick: () -> Unit,
    onLoginClick: () -> Unit,
    onJoinClubClick: () -> Unit
) {
    composable(
        route = PROFILE_ROUTE,
        enterTransition = { screenFadeIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenFadeOut() },
    ) {
        val viewModel: ProfileViewModel = hiltViewModel()
        val isLoggedIn by viewModel.isLoggedIn.collectAsState()

        ProfileScreen(
            isLoggedIn = isLoggedIn,
            onPurchaseHistoryClick = onPurchaseHistoryClick,
            onFindOutMoreClick = onFindOutMoreClick,
            onPromotionClick = onPromotionClick,
            onMyDataClick = onMyDataClick,
            onMyOrdersClick = onMyOrdersClick,
            onReturnsClick = onReturnsClick,
            onLoginClick = onLoginClick,
            onJoinClubClick = onJoinClubClick,
        )
    }
}
