package com.maruchin.features.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.features.profile.profile.PROFILE_ROUTE
import com.maruchin.features.profile.profile.profileScreen

const val PROFILE_GRAPH_ROUTE = "profile-graph"

fun NavGraphBuilder.profileGraph(navController: NavController) {
    navigation(startDestination = PROFILE_ROUTE, route = PROFILE_GRAPH_ROUTE) {
        profileScreen(
            onOpenSettings = {},
            onOpenPurchaseHistory = {},
            onOpenFindOutMore = {},
        )
    }
}
