package com.maruchin.features.registration

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
import com.maruchin.ui.ROOT_DEEPLINK

const val REGISTRATION_GRAPH_ROUTE = "registration-graph"
private const val REGISTRATION_DEEPLINK = "$ROOT_DEEPLINK/registration"

fun NavController.navigateToRegistrationGraph() {
    navigate(REGISTRATION_GRAPH_ROUTE)
}

fun NavGraphBuilder.registrationGraph(navController: NavController) {
    navigation(
        startDestination = REGISTRATION_ROUTE,
        route = REGISTRATION_GRAPH_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = REGISTRATION_DEEPLINK }
        )
    ) {
        registrationScreen(
            onBackClick = {
                navController.popBackStack()
            }
        )
    }
}
