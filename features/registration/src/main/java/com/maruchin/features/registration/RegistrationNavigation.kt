package com.maruchin.features.registration

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val REGISTRATION_ROUTE = "registration"

internal fun NavGraphBuilder.registrationScreen(onBackClick: () -> Unit) {
    composable(REGISTRATION_ROUTE) {
        val viewModel: RegistrationViewModel = hiltViewModel()
        val isLoggedIn by viewModel.isLoggedIn.collectAsState()

        if (isLoggedIn) {
            LaunchedEffect(Unit) {
                onBackClick()
            }
        }

        RegistrationScreen(
            onBackClick = onBackClick,
            onRegisterClick = viewModel::submitRegistration,
        )
    }
}
