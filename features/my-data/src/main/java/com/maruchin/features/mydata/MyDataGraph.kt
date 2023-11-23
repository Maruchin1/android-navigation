package com.maruchin.features.mydata

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
import com.maruchin.features.mydata.addaddress.addAddressScreen
import com.maruchin.features.mydata.addaddress.navigateToAddAddress
import com.maruchin.features.mydata.changepassword.changePasswordScreen
import com.maruchin.features.mydata.changepassword.navigateToChangePassword
import com.maruchin.features.mydata.deleteaccount.deleteAccountScreen
import com.maruchin.features.mydata.deleteaccount.navigateToDeleteAccount
import com.maruchin.features.mydata.editaddress.editAddressScreen
import com.maruchin.features.mydata.editaddress.navigateToEditAddress
import com.maruchin.features.mydata.editmydata.editMyDataScreen
import com.maruchin.features.mydata.editmydata.navigateToEditMyData
import com.maruchin.features.mydata.myaddresses.myAddresses
import com.maruchin.features.mydata.myaddresses.navigateToMyAddresses
import com.maruchin.features.mydata.mydata.MY_DATA_ROUTE
import com.maruchin.features.mydata.mydata.myDataScreen
import com.maruchin.ui.ROOT_DEEPLINK

const val MY_DATA_GRAPH_ROUTE = "my-data-graph"
private const val MY_DATA_DEEPLINK = "$ROOT_DEEPLINK/my-data"

fun NavController.navigateToMyDataGraph() {
    navigate(MY_DATA_GRAPH_ROUTE)
}

fun NavGraphBuilder.myDataGraph(navController: NavController, onNavigateToProfile: () -> Unit) {
    navigation(
        startDestination = MY_DATA_ROUTE,
        route = MY_DATA_GRAPH_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = MY_DATA_DEEPLINK }
        )
    ) {
        myDataScreen(
            onBackClick = {
                navController.popBackStack()
            },
            onPersonalDataClick = {
                navController.navigateToEditMyData()
            },
            onMyAddressesClick = {
                navController.navigateToMyAddresses()
            },
            onChangePasswordClick = {
                navController.navigateToChangePassword()
            },
            onDeleteAccountClick = {
                navController.navigateToDeleteAccount()
            },
            onLoggedOut = onNavigateToProfile
        )
        editMyDataScreen(
            onCloseClick = {
                navController.popBackStack()
            }
        )
        myAddresses(
            onBackClick = {
                navController.popBackStack()
            },
            onAddAddressClick = {
                navController.navigateToAddAddress()
            },
            onEditAddressClick = { addressId ->
                navController.navigateToEditAddress(addressId)
            }
        )
        addAddressScreen(
            onClose = {
                navController.popBackStack()
            }
        )
        editAddressScreen(
            onCloseClick = {
                navController.popBackStack()
            }
        )
        changePasswordScreen(
            onCloseClick = {
                navController.popBackStack()
            }
        )
        deleteAccountScreen(
            onCloseClick = {
                navController.popBackStack()
            },
            onNavigateToProfile = onNavigateToProfile
        )
    }
}
