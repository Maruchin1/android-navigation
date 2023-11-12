package com.maruchin.features.mydata.addaddress

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog

internal const val ADD_ADDRESS_ROUTE = "add-address"

internal fun NavGraphBuilder.addAddressScreen(onClose: () -> Unit) {
    dialog(
        ADD_ADDRESS_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: AddAddressViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        if (state.isSaved) {
            LaunchedEffect(Unit) {
                onClose()
            }
        }

        AddAddressScreen(onClose = onClose, onSaveClick = viewModel::submitAddAddress)
    }
}

internal fun NavController.navigateToAddAddress() {
    navigate(ADD_ADDRESS_ROUTE)
}
