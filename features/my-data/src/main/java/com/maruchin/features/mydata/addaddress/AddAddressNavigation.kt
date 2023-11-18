package com.maruchin.features.mydata.addaddress

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog

internal const val ADD_ADDRESS_ROUTE = "add-address"

internal fun NavController.navigateToAddAddress() {
    navigate(ADD_ADDRESS_ROUTE)
}

internal fun NavGraphBuilder.addAddressScreen(onClose: () -> Unit) {
    dialog(
        route = ADD_ADDRESS_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: AddAddressViewModel = hiltViewModel()

        if (viewModel.isSaved) {
            LaunchedEffect(Unit) {
                onClose()
            }
        }

        AddAddressScreen(onCloseClick = onClose, onSaveClick = viewModel::submitAddAddress)
    }
}
