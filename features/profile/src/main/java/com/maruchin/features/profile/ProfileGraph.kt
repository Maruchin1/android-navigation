package com.maruchin.features.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.features.profile.findoutmore.findOutMoreScreen
import com.maruchin.features.profile.findoutmore.navigateToFindOutMore
import com.maruchin.features.profile.profile.PROFILE_ROUTE
import com.maruchin.features.profile.profile.profileScreen
import com.maruchin.features.profile.purchasehistory.navigateToPurchaseHistory
import com.maruchin.features.profile.purchasehistory.purchaseHistoryScreen

const val PROFILE_GRAPH_ROUTE = "profile-graph"

fun NavGraphBuilder.profileGraph(navController: NavController) {
    navigation(startDestination = PROFILE_ROUTE, route = PROFILE_GRAPH_ROUTE) {
        profileScreen(
            onOpenSettings = {},
            onOpenPurchaseHistory = {
                navController.navigateToPurchaseHistory()
            },
            onOpenFindOutMore = {
                navController.navigateToFindOutMore()
            },
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
    }
}
