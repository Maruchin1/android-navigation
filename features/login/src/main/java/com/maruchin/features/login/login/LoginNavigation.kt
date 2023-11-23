package com.maruchin.features.login.login

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val LOGIN_ROUTE = "login"

internal fun NavGraphBuilder.loginScreen(
    onBackClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onLoggedIn: () -> Unit,
) {
    composable(route = LOGIN_ROUTE) {
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
