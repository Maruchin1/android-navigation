package com.maruchin.features.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
import com.maruchin.features.login.changepassword.changePasswordScreen
import com.maruchin.features.login.forgotpassword.forgotPasswordScreen
import com.maruchin.features.login.forgotpassword.navigateToForgotPassword
import com.maruchin.features.login.login.LOGIN_ROUTE
import com.maruchin.features.login.login.loginScreen
import com.maruchin.ui.ROOT_DEEPLINK

internal const val LOGIN_GRAPH_ROUTE = "login_graph"
private const val LOGIN_DEEPLINK = "$ROOT_DEEPLINK/login"

fun NavController.navigateToLoginGraph() {
    navigate(LOGIN_GRAPH_ROUTE)
}

fun NavGraphBuilder.loginGraph(
    navController: NavController,
    onRegisterClick: () -> Unit
) {
    navigation(
        startDestination = LOGIN_ROUTE,
        route = LOGIN_GRAPH_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = LOGIN_DEEPLINK }
        )
    ) {
        loginScreen(
            onBackClick = {
                navController.popBackStack()
            },
            onRegisterClick = onRegisterClick,
            onForgotPasswordClick = {
                navController.navigateToForgotPassword()
            },
            onLoggedIn = {
                navController.popBackStack()
            }
        )
        forgotPasswordScreen(
            onBackClick = {
                navController.popBackStack()
            },
        )
        changePasswordScreen(
            onCloseClick = {
                navController.popBackStack()
            },
            onLoggedIn = {
                navController.popBackStack(route = LOGIN_GRAPH_ROUTE, inclusive = true)
            }
        )
    }
}
