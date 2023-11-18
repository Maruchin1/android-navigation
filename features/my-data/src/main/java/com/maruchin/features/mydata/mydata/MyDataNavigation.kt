package com.maruchin.features.mydata.mydata

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val MY_DATA_ROUTE = "my-data"

internal fun NavGraphBuilder.myDataScreen(
    onBackClick: () -> Unit,
    onPersonalDataClick: () -> Unit,
    onMyAddressesClick: () -> Unit,
    onChangePasswordClick: () -> Unit,
    onDeleteAccountClick: () -> Unit,
    onLoggedOut: () -> Unit,
) {
    composable(MY_DATA_ROUTE) {
        val viewModel: MyDataViewModel = hiltViewModel()
        val personalData by viewModel.personalData.collectAsState()
        val isLoggedOut by viewModel.isLoggedOut.collectAsState()

        if (isLoggedOut) {
            LaunchedEffect(Unit) {
                onLoggedOut()
            }
        }

        MyDataScreen(
            personalData = personalData,
            onBackClick = onBackClick,
            onPersonalDataClick = onPersonalDataClick,
            onMyAddressesClick = onMyAddressesClick,
            onChangePasswordClick = onChangePasswordClick,
            onDeleteAccountClick = onDeleteAccountClick,
            onLogoutClick = viewModel::logout,
        )
    }
}
