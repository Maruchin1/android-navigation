package com.maruchin.features.profile.purchasehistory

import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog

internal const val PURCHASE_HISTORY_ROUTE = "purchase-history"

internal fun NavGraphBuilder.purchaseHistoryScreen(onClose: () -> Unit) {
    dialog(
        route = PURCHASE_HISTORY_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        PurchaseHistoryScreen(onClose = onClose)
    }
}

internal fun NavController.navigateToPurchaseHistory() {
    navigate(route = PURCHASE_HISTORY_ROUTE)
}
