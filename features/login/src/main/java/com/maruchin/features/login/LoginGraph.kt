package com.maruchin.features.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.features.login.changepassword.changePasswordScreen
import com.maruchin.features.login.forgotpassword.forgotPasswordScreen
import com.maruchin.features.login.forgotpassword.navigateToForgotPassword
import com.maruchin.features.login.login.LOGIN_ROUTE
import com.maruchin.features.login.login.loginScreen

internal const val LOGIN_GRAPH_ROUTE = "login_graph"

fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(startDestination = LOGIN_ROUTE, route = LOGIN_GRAPH_ROUTE) {
        loginScreen(
            onBack = {
                navController.navigateUp()
            },
            onRegister = {

            },
            onForgotPassword = {
                navController.navigateToForgotPassword()
            }
        )
        forgotPasswordScreen(
            onBack = {
                navController.navigateUp()
            },
        )
        changePasswordScreen(
            onClose = {
                navController.navigateUp()
            },
            onLoggedIn = {
                navController.popBackStack(route = LOGIN_GRAPH_ROUTE, inclusive = true)
            }
        )
    }
}

fun NavController.navigateToLoginGraph() {
    navigate(LOGIN_GRAPH_ROUTE)
}
