package com.maruchin.androidnavigation.root

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maruchin.androidnavigation.navigationbar.NAVIGATION_BAR_HOST_ROUTE
import com.maruchin.androidnavigation.navigationbar.navigationBarHost
import com.maruchin.ui.screenSlideIn
import com.maruchin.ui.screenSlideOut
import com.maruchin.features.login.loginGraph
import com.maruchin.features.login.navigateToLoginGraph
import com.maruchin.features.order.ORDER_GRAPH_ROUTE
import com.maruchin.features.order.navigateToOrderGraph
import com.maruchin.features.order.orderGraph
import com.maruchin.features.productcard.navigateToProductCardGraph
import com.maruchin.features.registration.navigateToRegistrationGraph
import com.maruchin.features.registration.registrationGraph

@Composable
internal fun RootHost() {
    val rootController = rememberNavController()
    val navigationBarController = rememberNavController()

    NavHost(
        navController = rootController,
        startDestination = NAVIGATION_BAR_HOST_ROUTE,
        enterTransition = { screenSlideIn() },
        exitTransition = { com.maruchin.ui.screenFadeOut() },
        popEnterTransition = { com.maruchin.ui.screenFadeIn() },
        popExitTransition = { screenSlideOut() },
    ) {
        navigationBarHost(
            navController = navigationBarController,
            onNavigateToLogin = {
                rootController.navigateToLoginGraph()
            },
            onNavigateToJoinClub = {
                rootController.navigateToRegistrationGraph()
            },
            onNavigateToOrder = {
                rootController.navigateToOrderGraph()
            }
        )
        loginGraph(
            navController = rootController,
            onNavigateToRegistration = {
                rootController.navigateToRegistrationGraph()
            }
        )
        registrationGraph(navController = rootController)
        orderGraph(
            navController = rootController,
            onProductClick = { productId ->
                rootController.popBackStack(ORDER_GRAPH_ROUTE, inclusive = true)
                navigationBarController.navigateToProductCardGraph(productId)
            }
        )
    }
}