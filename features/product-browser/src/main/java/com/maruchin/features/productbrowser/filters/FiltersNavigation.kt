package com.maruchin.features.productbrowser.filters

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog

private const val FILTERS_ROUTE = "filters"

internal fun NavGraphBuilder.filtersScreen(onBackClick: () -> Unit) {
    dialog(
        route = FILTERS_ROUTE,
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val viewModel: FiltersViewModel = hiltViewModel()
        val filters by viewModel.filters.collectAsState()

        FiltersScreen(
            filters = filters,
            onBackClick = onBackClick,
            onSortingChange = viewModel::updateSorting,
            onPriceChange = viewModel::updatePrice,
        )
    }
}

internal fun NavController.navigateToFilters() {
    navigate(FILTERS_ROUTE)
}
