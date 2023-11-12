package com.maruchin.features.profile

import android.content.Context
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.core.intent.openWebsite
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

fun NavGraphBuilder.profileGraph(
    navController: NavController,
    context: Context,
    onNavigateToMyData: () -> Unit,
    onNavigateToLogin: () -> Unit,
    onNavigateToJoinClub: () -> Unit,
) {
    navigation(startDestination = PROFILE_ROUTE, route = PROFILE_GRAPH_ROUTE) {
        profileScreen(
            onOpenPurchaseHistory = {
                navController.navigateToPurchaseHistory()
            },
            onOpenFindOutMore = {
                navController.navigateToFindOutMore()
            },
            onOpenPromotion = { promotionId ->
                navController.navigateToPromotion(promotionId)
            },
            onOpenMyData = onNavigateToMyData,
            onOpenMyOrders = {
                navController.navigateToMyOrders()
            },
            onOpenReturns = {
                navController.navigateToReturns()
            },
            onNavigateToLogin = onNavigateToLogin,
            onNavigateToJoinClub = onNavigateToJoinClub,
        )
        purchaseHistoryScreen(
            onClose = {
                navController.navigateUp()
            }
        )
        findOutMoreScreen(
            onClose = {
                navController.navigateUp()
            }
        )
        promotionScreen(
            onBack = {
                navController.navigateUp()
            }
        )
        myOrdersScreen(
            onBack = {
                navController.navigateUp()
            }
        )
        returnsScreen(
            onBack = {
                navController.navigateUp()
            },
            onNavigateToReturnsForm = {
                val url = "https://developers.android.com"
                context.openWebsite(url.toUri())
            }
        )
    }
}

fun NavController.navigateToProfileGraph() {
    navigate(PROFILE_GRAPH_ROUTE) {
        popUpTo(PROFILE_GRAPH_ROUTE) {
            inclusive = true
        }
    }
}
