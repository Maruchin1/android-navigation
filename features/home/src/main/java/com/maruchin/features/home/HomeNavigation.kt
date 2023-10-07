package com.maruchin.features.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.categories.Category

const val HOME_ROUTE = "home"

fun NavGraphBuilder.homeScreen(onShowAllFromCategory: (Category) -> Unit) {
    composable(HOME_ROUTE) {
        HomeScreen(onShowAllFromCategory = onShowAllFromCategory)
    }
}