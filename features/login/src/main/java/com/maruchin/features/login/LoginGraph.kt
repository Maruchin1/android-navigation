package com.maruchin.features.login

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.features.login.changepassword.changePasswordScreen
import com.maruchin.features.login.forgotpassword.forgotPasswordScreen
import com.maruchin.features.login.forgotpassword.navigateToForgotPassword
import com.maruchin.features.login.login.LOGIN_ROUTE
import com.maruchin.features.login.login.loginScreen
import kotlinx.coroutines.flow.StateFlow

internal const val LOGIN_GRAPH_ROUTE = "login_graph"
private const val LOGIN_SUCCESS = "login_success"

fun NavGraphBuilder.loginGraph(navController: NavController, onNavigateToRegistration: () -> Unit) {
    navigation(startDestination = LOGIN_ROUTE, route = LOGIN_GRAPH_ROUTE) {
        loginScreen(
            onBack = {
                navController.navigateUp()
            },
            onRegister = onNavigateToRegistration,
            onForgotPassword = {
                navController.navigateToForgotPassword()
            },
            onLoggedIn = {
                navController.setLoginSuccess(true)
                navController.popBackStack()
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
                navController.setLoginSuccess(true)
                navController.popBackStack(route = LOGIN_GRAPH_ROUTE, inclusive = true)
            }
        )
    }
}

fun NavController.navigateToLoginGraph() {
    navigate(LOGIN_GRAPH_ROUTE)
}

fun SavedStateHandle.getLoginSuccess(): StateFlow<Boolean> {
    return getStateFlow(LOGIN_SUCCESS, false)
}

fun NavController.setLoginSuccess(success: Boolean) {
    val previousEntry = checkNotNull(previousBackStackEntry)
    previousEntry.savedStateHandle[LOGIN_SUCCESS] = success
}
