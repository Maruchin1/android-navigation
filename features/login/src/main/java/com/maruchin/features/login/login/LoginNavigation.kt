package com.maruchin.features.login.login

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.maruchin.ui.ROOT_DEEPLINK

internal const val LOGIN_ROUTE = "login"
private const val LOGIN_DEEPLINK = "$ROOT_DEEPLINK/login"

internal fun NavGraphBuilder.loginScreen(
    onBackClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onLoggedIn: () -> Unit,
) {
    composable(
        route = LOGIN_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = LOGIN_DEEPLINK }
        )
    ) {
        val viewModel: LoginViewModel = hiltViewModel()
        val isLoggedIn by viewModel.isLoggedIn.collectAsState()

        if (isLoggedIn) {
            LaunchedEffect(Unit) {
                onLoggedIn()
            }
        }

        LoginScreen(
            onBackClick = onBackClick,
            onLoginClick = viewModel::login,
            onRegisterClick = onRegisterClick,
            onForgotPasswordClick = onForgotPasswordClick,
        )
    }
}
