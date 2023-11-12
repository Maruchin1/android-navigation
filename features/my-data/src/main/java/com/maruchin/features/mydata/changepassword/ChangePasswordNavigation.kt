package com.maruchin.features.mydata.changepassword

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog

internal const val CHANGE_PASSWORD_ROUTE = "change-password"

internal fun NavGraphBuilder.changePasswordScreen(onClose: () -> Unit) {
    dialog(
        CHANGE_PASSWORD_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: ChangePasswordViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        if (state.isSaved) {
            LaunchedEffect(Unit) {
                onClose()
            }
        }

        ChangePasswordScreen(
            onClose = onClose,
            onSaveClick = viewModel::changePassword,
        )
    }
}

internal fun NavController.navigateToChangePassword() {
    navigate(CHANGE_PASSWORD_ROUTE)
}
