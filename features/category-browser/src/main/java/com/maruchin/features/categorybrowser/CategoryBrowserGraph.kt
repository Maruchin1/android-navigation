package com.maruchin.features.categorybrowser

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.maruchin.data.categories.Category
import com.maruchin.features.categorybrowser.categorylist.CATEGORY_LIST_ROUTE
import com.maruchin.features.categorybrowser.categorylist.categoryListScreen
import com.maruchin.features.categorybrowser.subcategorylist.navigateToSubcategoryList
import com.maruchin.features.categorybrowser.subcategorylist.subcategoryListScreen

const val CATEGORY_BROWSER_GRAPH_ROUTE = "category-browser-graph"

fun NavGraphBuilder.categoryBrowserGraph(
    navController: NavController,
    onShowCategory: (Category) -> Unit,
) {

    fun showCategory(category: Category) {
        if (category.isFinal) {
            onShowCategory(category)
        } else {
            navController.navigateToSubcategoryList(category.id)
        }
    }

    navigation(startDestination = CATEGORY_LIST_ROUTE, route = CATEGORY_BROWSER_GRAPH_ROUTE) {
        categoryListScreen(
            onShowCategory = { category ->
                showCategory(category)
            },
        )
        subcategoryListScreen(
            onBack = {
                navController.navigateUp()
            },
            onShowCategory = { category ->
                showCategory(category)
            }
        )
    }
}
