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

internal fun NavController.navigateToEditMyData() {
    navigate(EDIT_MY_DATE_ROUTE)
}

internal fun NavGraphBuilder.editMyDataScreen(onCloseClick: () -> Unit) {
    dialog(
        route = EDIT_MY_DATE_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: EditMyDataViewModel = hiltViewModel()
        val personalData by viewModel.personalData.collectAsState()

        if (viewModel.isSaved) {
            LaunchedEffect(Unit) {
                onCloseClick()
            }
        }

        EditMyDataScreen(
            personalData = personalData,
            onCloseClick = onCloseClick,
            onSaveClick = viewModel::submitChange,
        )
    }
}
