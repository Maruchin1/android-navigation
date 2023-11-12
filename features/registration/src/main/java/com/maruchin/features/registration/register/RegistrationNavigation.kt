package com.maruchin.features.registration.register

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val REGISTRATION_ROUTE = "registration"

internal fun NavGraphBuilder.registrationScreen(onBack: () -> Unit) {
    composable(REGISTRATION_ROUTE) {
        val viewModel: RegistrationViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        if (state.isRegistered) {
            LaunchedEffect(Unit) {
                onBack()
            }
        }

        RegistrationScreen(
            onBack = onBack,
            onRegisterClick = viewModel::submitRegistration,
        )
    }
}
