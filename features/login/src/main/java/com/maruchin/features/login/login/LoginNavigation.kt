package com.maruchin.features.login.login

import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.maruchin.core.ui.ROOT_DEEPLINK
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal const val LOGIN_ROUTE = "login"
private const val LOGIN_DEEPLINK = "$ROOT_DEEPLINK/login"

internal fun NavGraphBuilder.loginScreen(
    onBack: () -> Unit,
    onRegister: () -> Unit,
    onForgotPassword: () -> Unit,
    onLoggedIn: () -> Unit,
) {
    composable(
        route = LOGIN_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = LOGIN_DEEPLINK }
        )
    ) {
        val viewModel: LoginViewModel = hiltViewModel()

        LaunchedEffect(Unit) {
            viewModel.isLoggedIn
                .filter { it }
                .onEach { onLoggedIn() }
                .launchIn(this)
        }

        LoginScreen(
            loginFormState = viewModel.loginFormState,
            isLoading = viewModel.isLoading,
            onBack = onBack,
            onLogin = viewModel::login,
            onRegister = onRegister,
            onForgotPassword = onForgotPassword,
        )
    }
}
