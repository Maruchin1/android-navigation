package com.maruchin.features.login.changepassword

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import kotlinx.coroutines.flow.filterIsInstance

private const val EMAIL = "email"
private const val TOKEN = "token"
internal const val CHANGE_PASSWORD_ROUTE = "change_password"
internal const val CHANGE_PASSWORD_LINK =
    "app://com.maruchin.androidnavigation/change-password/{$EMAIL}/{$TOKEN}"

internal data class ChangePasswordArgs(val email: String, val token: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        email = checkNotNull(savedStateHandle[EMAIL]),
        token = checkNotNull(savedStateHandle[TOKEN]),
    )
}

internal fun NavGraphBuilder.changePasswordScreen(onClose: () -> Unit, onLoggedIn: () -> Unit) {
    composable(
        route = CHANGE_PASSWORD_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = CHANGE_PASSWORD_LINK }
        )
    ) {
        val viewModel: ChangePasswordViewModel = hiltViewModel()

        LaunchedEffect(Unit) {
            snapshotFlow { viewModel.passwordChangeState }
                .filterIsInstance<PasswordChangeState.LoggedIn>()
                .collect { onLoggedIn() }
        }

        ChangePasswordScreen(
            changePasswordFormState = viewModel.changePasswordFormState,
            passwordChangeState = viewModel.passwordChangeState,
            onClose = onClose,
            onChangePassword = viewModel::changePassword,
        )
    }
}
