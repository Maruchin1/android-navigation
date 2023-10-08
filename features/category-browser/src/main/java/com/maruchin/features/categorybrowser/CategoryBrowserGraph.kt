package com.maruchin.features.categorybrowser

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.maruchin.data.categories.Category
import com.maruchin.features.categorybrowser.categorylist.CATEGORY_LIST_ROUTE
import com.maruchin.features.categorybrowser.categorylist.categoryListScreen

const val CATEGORY_BROWSER_GRAPH_ROUTE = "category-browser-graph"

fun NavGraphBuilder.categoryBrowserGraph(
    navController: NavController,
    onShowCategory: (Category) -> Unit,
) {
    navigation(startDestination = CATEGORY_LIST_ROUTE, route = CATEGORY_BROWSER_GRAPH_ROUTE) {
        categoryListScreen(
            onShowCategory = onShowCategory,
        )
    }
}
