package com.maruchin.features.productbrowser.filters

import androidx.compose.runtime.collectAsState
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog

private const val FILTERS_ROUTE = "filters"

internal fun NavGraphBuilder.filtersScreen(onBack: () -> Unit) {
    dialog(
        route = FILTERS_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: FiltersViewModel = hiltViewModel()
        FiltersScreen(
            filters = viewModel.filters.collectAsState().value,
            onBack = onBack,
            onSortingChange = viewModel::updateSorting,
            onPriceChange = viewModel::updatePrice
        )
    }
}

internal fun NavController.navigateToFilters() {
    navigate(FILTERS_ROUTE)
}
