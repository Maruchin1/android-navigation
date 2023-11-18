package com.maruchin.features.profile

import android.content.Context
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
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

const val PROFILE_GRAPH_ROUTE = "profile-graph"

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
    navigation(startDestination = PROFILE_ROUTE, route = PROFILE_GRAPH_ROUTE) {
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
                navController.navigateUp()
            }
        )
        findOutMoreScreen(
            onCloseClick = {
                navController.navigateUp()
            }
        )
        promotionScreen(
            onBackClick = {
                navController.navigateUp()
            }
        )
        myOrdersScreen(
            onBackClick = {
                navController.navigateUp()
            }
        )
        returnsScreen(
            onBackClick = {
                navController.navigateUp()
            },
            onGoToFormClick = {
                val url = "https://developers.android.com"
                context.openWebsite(url.toUri())
            }
        )
    }
}
