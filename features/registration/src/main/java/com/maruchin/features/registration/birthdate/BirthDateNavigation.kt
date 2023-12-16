package com.maruchin.features.registration.birthdate

import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.features.registration.registrationform.REGISTRATION_ROUTE

internal const val BIRTH_DATE_ROUTE = "birth-date"

internal fun NavController.navigateToBirthDate() {
    navigate(BIRTH_DATE_ROUTE) {
        popUpTo(REGISTRATION_ROUTE) {
            inclusive = true
        }
    }
}

internal fun NavGraphBuilder.birthDateScreen(onExitRegistration: () -> Unit) {
    composable(BIRTH_DATE_ROUTE) {
        val viewModel: BirthDateViewModel = hiltViewModel()

        if (viewModel.birthDateSaved) {
            LaunchedEffect(Unit) {
                onExitRegistration()
            }
        }

        BirthDateScreen(
            onCloseClick = onExitRegistration,
            onSaveBirthDateClick = viewModel::saveBirthDate
        )
    }
}
