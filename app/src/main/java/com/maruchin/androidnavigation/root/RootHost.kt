package com.maruchin.androidnavigation.root

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maruchin.androidnavigation.navigationbar.NAVIGATION_BAR_HOST_ROUTE
import com.maruchin.androidnavigation.navigationbar.navigationBarHost
import com.maruchin.core.ui.screenFadeIn
import com.maruchin.core.ui.screenFadeOut
import com.maruchin.core.ui.screenSlideIn
import com.maruchin.core.ui.screenSlideOut
import com.maruchin.features.login.loginGraph
import com.maruchin.features.login.navigateToLoginGraph

@Composable
internal fun RootHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NAVIGATION_BAR_HOST_ROUTE,
        enterTransition = { screenSlideIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenSlideOut() },
    ) {
        navigationBarHost(
            onNavigateToLogin = {
                navController.navigateToLoginGraph()
            },
            onNavigateToJoinClub = {

            }
        )
        loginGraph(navController)
    }
}