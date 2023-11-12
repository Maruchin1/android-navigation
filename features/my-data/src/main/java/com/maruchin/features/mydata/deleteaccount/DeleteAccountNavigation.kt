package com.maruchin.features.mydata.deleteaccount

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog

internal const val DELETE_ACCOUNT_ROUTE = "delete-account"

internal fun NavGraphBuilder.deleteAccountScreen(
    onClose: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    dialog(
        DELETE_ACCOUNT_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: DeleteAccountViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        if (state.isDeleted) {
            LaunchedEffect(Unit) {
                onNavigateToProfile()
            }
        }

        DeleteAccountScreen(
            onClose = onClose,
            onStartDeletingClick = viewModel::deleteAccount
        )
    }
}

internal fun NavController.navigateToDeleteAccount() {
    navigate(DELETE_ACCOUNT_ROUTE)
}
