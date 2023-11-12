package com.maruchin.features.mydata.editmydata

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog

internal const val EDIT_MY_DATE_ROUTE = "edit-my-data"

internal fun NavGraphBuilder.editMyDataScreen(onClose: () -> Unit) {
    dialog(
        EDIT_MY_DATE_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: EditMyDataViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        if (state.isSaved) {
            LaunchedEffect(Unit) {
                onClose()
            }
        }

        EditMyDataScreen(
            state = state,
            onClose = onClose,
            onSaveClick = viewModel::submitChange,
        )
    }
}

internal fun NavController.navigateToEditMyData() {
    navigate(EDIT_MY_DATE_ROUTE)
}
