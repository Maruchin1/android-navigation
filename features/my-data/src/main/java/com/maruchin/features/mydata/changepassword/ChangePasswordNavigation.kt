package com.maruchin.features.mydata.changepassword

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog

internal const val CHANGE_PASSWORD_ROUTE = "change-password"

internal fun NavController.navigateToChangePassword() {
    navigate(CHANGE_PASSWORD_ROUTE)
}

internal fun NavGraphBuilder.changePasswordScreen(onCloseClick: () -> Unit) {
    dialog(
        route = CHANGE_PASSWORD_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: ChangePasswordViewModel = hiltViewModel()

        if (viewModel.isSaved) {
            LaunchedEffect(Unit) {
                onCloseClick()
            }
        }

        ChangePasswordScreen(
            onCloseClick = onCloseClick,
            onSaveClick = viewModel::changePassword,
        )
    }
}
