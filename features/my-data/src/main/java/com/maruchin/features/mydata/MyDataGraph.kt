package com.maruchin.features.mydata

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
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

const val MY_DATA_GRAPH_ROUTE = "my-data-graph"

fun NavGraphBuilder.myDataGraph(navController: NavController, onNavigateToProfile: () -> Unit) {
    navigation(startDestination = MY_DATA_ROUTE, route = MY_DATA_GRAPH_ROUTE) {
        myDataScreen(
            onBack = {
                navController.navigateUp()
            },
            onNavigateToEditMyData = {
                navController.navigateToEditMyData()
            },
            onNavigateToMyAddresses = {
                navController.navigateToMyAddresses()
            },
            onNavigateToChangePassword = {
                navController.navigateToChangePassword()
            },
            onNavigateToDeleteAccount = {
                navController.navigateToDeleteAccount()
            },
            onNavigateToProfile = onNavigateToProfile
        )
        editMyDataScreen(
            onClose = {
                navController.navigateUp()
            }
        )
        myAddresses(
            onBack = {
                navController.navigateUp()
            },
            onNavigateToAddAddress = {
                navController.navigateToAddAddress()
            },
            onNavigateToEditAddress = { addressId ->
                navController.navigateToEditAddress(addressId)
            }
        )
        addAddressScreen(
            onClose = {
                navController.navigateUp()
            }
        )
        editAddressScreen(
            onClose = {
                navController.navigateUp()
            }
        )
        changePasswordScreen(
            onClose = {
                navController.navigateUp()
            }
        )
        deleteAccountScreen(
            onClose = {
                navController.navigateUp()
            },
            onNavigateToProfile = onNavigateToProfile
        )
    }
}

fun NavController.navigateToMyDataGraph() {
    navigate(MY_DATA_GRAPH_ROUTE)
}
