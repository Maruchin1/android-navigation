package com.maruchin.features.login.login

import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val LOGIN_ROUTE = "login"

internal fun NavGraphBuilder.loginScreen(onBack: () -> Unit, onRegister: () -> Unit) {
    composable(LOGIN_ROUTE) {
        val viewModel: LoginViewModel = hiltViewModel()

        LaunchedEffect(Unit) {
            viewModel.isLoggedIn.collect { isLoggedIn ->
                if (isLoggedIn) onBack()
            }
        }

        LoginScreen(
            loginFormState = viewModel.loginFormState,
            isLoading = viewModel.isLoading,
            onBack = onBack,
            onLogin = viewModel::login,
            onRegister = onRegister,
        )
    }
}
