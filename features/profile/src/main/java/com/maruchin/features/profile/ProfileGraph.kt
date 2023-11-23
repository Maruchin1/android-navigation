package com.maruchin.features.profile

import android.content.Context
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
import com.maruchin.ui.openWebsite
import com.maruchin.features.profile.findoutmore.findOutMoreScreen
import com.maruchin.features.profile.findoutmore.navigateToFindOutMore
import com.maruchin.features.profile.myorders.myOrdersScreen
import com.maruchin.features.profile.myorders.navigateToMyOrders
import com.maruchin.features.profile.profile.PROFILE_ROUTE
import com.maruchin.features.profile.profile.profileScreen
import com.maruchin.features.profile.promotion.navigateToPromotion
import com.maruchin.features.profile.promotion.promotionScreen
import com.maruchin.features.profile.purchasehistory.navigateToPurchaseHistory
import com.maruchin.features.profile.purchasehistory.purchaseHistoryScreen
import com.maruchin.features.profile.returns.navigateToReturns
import com.maruchin.features.profile.returns.returnsScreen
import com.maruchin.ui.ROOT_DEEPLINK

const val PROFILE_GRAPH_ROUTE = "profile-graph"
private const val PROFILE_DEEPLINK = "$ROOT_DEEPLINK/profile"

fun NavController.navigateToProfileGraph() {
    navigate(PROFILE_GRAPH_ROUTE) {
        popUpTo(PROFILE_GRAPH_ROUTE) {
            inclusive = true
        }
    }
}

fun NavGraphBuilder.profileGraph(
    navController: NavController,
    context: Context,
    onMyDataClick: () -> Unit,
    onLoginClick: () -> Unit,
    onJoinClubClick: () -> Unit,
) {
    navigation(
        startDestination = PROFILE_ROUTE,
        route = PROFILE_GRAPH_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = PROFILE_DEEPLINK }
        )
    ) {
        profileScreen(
            onPurchaseHistoryClick = {
                navController.navigateToPurchaseHistory()
            },
            onFindOutMoreClick = {
                navController.navigateToFindOutMore()
            },
            onPromotionClick = { promotionId ->
                navController.navigateToPromotion(promotionId)
            },
            onMyDataClick = onMyDataClick,
            onMyOrdersClick = {
                navController.navigateToMyOrders()
            },
            onReturnsClick = {
                navController.navigateToReturns()
            },
            onLoginClick = onLoginClick,
            onJoinClubClick = onJoinClubClick,
        )
        purchaseHistoryScreen(
            onCloseClick = {
                navController.popBackStack()
            }
        )
        findOutMoreScreen(
            onCloseClick = {
                navController.popBackStack()
            }
        )
        promotionScreen(
            onBackClick = {
                navController.popBackStack()
            }
        )
        myOrdersScreen(
            onBackClick = {
                navController.popBackStack()
            }
        )
        returnsScreen(
            onBackClick = {
                navController.popBackStack()
            },
            onGoToFormClick = {
                val url = "https://developers.android.com"
                context.openWebsite(url.toUri())
            }
        )
    }
}
