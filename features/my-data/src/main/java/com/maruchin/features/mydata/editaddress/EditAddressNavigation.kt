package com.maruchin.features.mydata.editaddress

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog

private const val ADDRESS_ID = "addressId"
internal const val EDIT_ADDRESS_ROUTE = "edit-address/{$ADDRESS_ID}"

internal data class EditAddressArgs(val addressId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        addressId = checkNotNull(savedStateHandle[ADDRESS_ID])
    )
}

internal fun NavController.navigateToEditAddress(addressId: String) {
    navigate(EDIT_ADDRESS_ROUTE.replace("{$ADDRESS_ID}", addressId))
}

internal fun NavGraphBuilder.editAddressScreen(onCloseClick: () -> Unit) {
    dialog(
        route = EDIT_ADDRESS_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: EditAddressViewModel = hiltViewModel()
        val address by viewModel.address.collectAsState()

        if (viewModel.isSaved) {
            LaunchedEffect(Unit) {
                onCloseClick()
            }
        }

        EditAddressScreen(
            address = address,
            onCloseClick = onCloseClick,
            onSaveClick = viewModel::saveAddress,
        )
    }
}
