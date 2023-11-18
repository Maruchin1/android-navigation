package com.maruchin.features.registration

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

const val REGISTRATION_GRAPH_ROUTE = "registration-graph"

fun NavController.navigateToRegistrationGraph() {
    navigate(REGISTRATION_GRAPH_ROUTE)
}

fun NavGraphBuilder.registrationGraph(navController: NavController) {
    navigation(startDestination = REGISTRATION_ROUTE, route = REGISTRATION_GRAPH_ROUTE) {
        registrationScreen(
            onBackClick = {
                navController.navigateUp()
            }
        )
    }
}
