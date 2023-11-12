package com.maruchin.features.mydata.mydata

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val MY_DATA_ROUTE = "my-data"

internal fun NavGraphBuilder.myDataScreen(
    onBack: () -> Unit,
    onNavigateToEditMyData: () -> Unit,
    onNavigateToMyAddresses: () -> Unit,
    onNavigateToChangePassword: () -> Unit,
    onNavigateToDeleteAccount: () -> Unit,
) {
    composable(MY_DATA_ROUTE) {
        val viewModel: MyDataViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()

        MyDataScreen(
            state = state,
            onBack = onBack,
            onPersonalDataClick = onNavigateToEditMyData,
            onMyAddressesClick = onNavigateToMyAddresses,
            onChangePasswordClick = onNavigateToChangePassword,
            onDeleteAccountClick = onNavigateToDeleteAccount,
        )
    }
}
