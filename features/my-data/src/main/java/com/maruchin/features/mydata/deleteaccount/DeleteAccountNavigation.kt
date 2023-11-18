package com.maruchin.features.mydata.deleteaccount

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog

internal const val DELETE_ACCOUNT_ROUTE = "delete-account"

internal fun NavController.navigateToDeleteAccount() {
    navigate(DELETE_ACCOUNT_ROUTE)
}

internal fun NavGraphBuilder.deleteAccountScreen(
    onCloseClick: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    dialog(
        route = DELETE_ACCOUNT_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: DeleteAccountViewModel = hiltViewModel()

        if (viewModel.isDeleted) {
            LaunchedEffect(Unit) {
                onNavigateToProfile()
            }
        }

        DeleteAccountScreen(
            onCloseClick = onCloseClick,
            onStartDeletingClick = viewModel::deleteAccount
        )
    }
}
