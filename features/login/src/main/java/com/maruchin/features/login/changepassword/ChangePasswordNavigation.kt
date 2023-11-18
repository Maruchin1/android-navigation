package com.maruchin.features.login.changepassword

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.maruchin.ui.ROOT_DEEPLINK

private const val EMAIL = "email"
private const val TOKEN = "token"
internal const val CHANGE_PASSWORD_ROUTE = "change_password"
internal const val CHANGE_PASSWORD_LINK = "$ROOT_DEEPLINK/change-password/{$EMAIL}/{$TOKEN}"

internal data class ChangePasswordArgs(val email: String, val token: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        email = checkNotNull(savedStateHandle[EMAIL]),
        token = checkNotNull(savedStateHandle[TOKEN]),
    )
}

internal fun NavGraphBuilder.changePasswordScreen(
    onCloseClick: () -> Unit,
    onLoggedIn: () -> Unit,
) {
    composable(
        route = CHANGE_PASSWORD_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = CHANGE_PASSWORD_LINK }
        )
    ) {
        val viewModel: ChangePasswordViewModel = hiltViewModel()
        val isLoggedIn by viewModel.isLoggedIn.collectAsState()

        if (isLoggedIn) {
            LaunchedEffect(Unit) {
                onLoggedIn()
            }
        }

        ChangePasswordScreen(
            onCloseClick = onCloseClick,
            onChangePasswordClick = viewModel::changePassword,
        )
    }
}
