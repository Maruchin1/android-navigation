package com.maruchin.features.categorybrowser

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.maruchin.data.categories.CategoryId
import com.maruchin.features.categorybrowser.categorylist.CATEGORY_LIST_ROUTE
import com.maruchin.features.categorybrowser.categorylist.categoryListScreen
import com.maruchin.features.categorybrowser.subcategorylist.navigateToSubcategoryList
import com.maruchin.features.categorybrowser.subcategorylist.subcategoryListScreen

const val CATEGORY_BROWSER_GRAPH_ROUTE = "category-browser-graph"

fun NavGraphBuilder.categoryBrowserGraph(
    navController: NavController,
    onNavigateToProductBrowser: (CategoryId) -> Unit,
) {
    navigation(startDestination = CATEGORY_LIST_ROUTE, route = CATEGORY_BROWSER_GRAPH_ROUTE) {
        categoryListScreen(
            onNavigateToSubcategoryList = { categoryId ->
                navController.navigateToSubcategoryList(categoryId)
            },
            onNavigateToProductBrowser = onNavigateToProductBrowser
        )
        subcategoryListScreen(
            onNavigateBack = {
                navController.navigateUp()
            },
            onNavigateToSubcategoryList = { categoryId ->
                navController.navigateToSubcategoryList(categoryId)
            },
            onNavigateToProductBrowser = onNavigateToProductBrowser,
        )
    }
}
