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
import com.maruchin.data.addresses.AddressId

private const val ADDRESS_ID = "addressId"
internal const val EDIT_ADDRESS_ROUTE = "edit-address/{$ADDRESS_ID}"

internal data class EditAddressArgs(val addressId: AddressId) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        addressId = AddressId(savedStateHandle[ADDRESS_ID]!!)
    )
}

internal fun NavGraphBuilder.editAddressScreen(onClose: () -> Unit) {
    dialog(
        EDIT_ADDRESS_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: EditAddressViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        if (state.isSaved) {
            LaunchedEffect(Unit) {
                onClose()
            }
        }

        EditAddressScreen(
            state = state,
            onClose = onClose,
            onSaveClick = viewModel::saveAddress,
        )
    }
}

internal fun NavController.navigateToEditAddress(addressId: AddressId) {
    navigate(EDIT_ADDRESS_ROUTE.replace("{$ADDRESS_ID}", addressId.value))
}
