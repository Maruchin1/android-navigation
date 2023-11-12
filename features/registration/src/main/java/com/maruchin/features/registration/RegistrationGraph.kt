package com.maruchin.features.registration

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.features.registration.register.REGISTRATION_ROUTE
import com.maruchin.features.registration.register.registrationScreen

const val REGISTRATION_GRAPH_ROUTE = "registration-graph"

fun NavGraphBuilder.registrationGraph(navController: NavController) {
    navigation(startDestination = REGISTRATION_ROUTE, route = REGISTRATION_GRAPH_ROUTE) {
        registrationScreen(
            onBack = {
                navController.navigateUp()
            }
        )
    }
}

fun NavController.navigateToRegistrationGraph() {
    navigate(REGISTRATION_GRAPH_ROUTE)
}
