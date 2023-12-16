package com.maruchin.features.registration.registrationform

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val REGISTRATION_ROUTE = "registration-form"

internal fun NavGraphBuilder.registrationFormScreen(
    onNavigateBack: () -> Unit,
    onNavigateToBirthDate: () -> Unit
) {
    composable(REGISTRATION_ROUTE) {
        val viewModel: RegistrationViewModel = hiltViewModel()
        val isLoggedIn by viewModel.isLoggedIn.collectAsState()

        if (isLoggedIn) {
            LaunchedEffect(Unit) {
                onNavigateToBirthDate()
            }
        }

        RegistrationFormScreen(
            onBackClick = onNavigateBack,
            onRegisterClick = viewModel::submitRegistration,
        )
    }
}
