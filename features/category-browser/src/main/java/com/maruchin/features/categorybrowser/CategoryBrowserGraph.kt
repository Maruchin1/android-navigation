package com.maruchin.features.categorybrowser

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.maruchin.features.categorybrowser.categorylist.CATEGORY_LIST_ROUTE
import com.maruchin.features.categorybrowser.categorylist.categoryListScreen
import com.maruchin.features.categorybrowser.subcategorylist.navigateToSubcategoryList
import com.maruchin.features.categorybrowser.subcategorylist.subcategoryListScreen

const val CATEGORY_BROWSER_GRAPH_ROUTE = "category-browser-graph"

fun NavGraphBuilder.categoryBrowserGraph(
    navController: NavController,
    onFinalCategoryClick: (categoryId: String) -> Unit,
) {
    navigation(startDestination = CATEGORY_LIST_ROUTE, route = CATEGORY_BROWSER_GRAPH_ROUTE) {
        categoryListScreen(
            onCategoryClick = { categoryId, isFinal ->
                if (isFinal) {
                    onFinalCategoryClick(categoryId)
                } else {
                    navController.navigateToSubcategoryList(categoryId)
                }
            },
        )
        subcategoryListScreen(
            onBackClick = {
                navController.navigateUp()
            },
            onCategoryClick = { categoryId, isFinal ->
                if (isFinal) {
                    onFinalCategoryClick(categoryId)
                } else {
                    navController.navigateToSubcategoryList(categoryId)
                }
            }
        )
    }
}
