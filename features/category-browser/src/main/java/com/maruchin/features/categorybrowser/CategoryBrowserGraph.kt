package com.maruchin.features.categorybrowser

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
import com.maruchin.features.categorybrowser.categorylist.CATEGORY_LIST_ROUTE
import com.maruchin.features.categorybrowser.categorylist.categoryListScreen
import com.maruchin.features.categorybrowser.subcategorylist.navigateToSubcategoryList
import com.maruchin.features.categorybrowser.subcategorylist.subcategoryListScreen
import com.maruchin.ui.ROOT_DEEPLINK
import com.maruchin.ui.screenFadeIn
import com.maruchin.ui.screenFadeOut

const val CATEGORY_BROWSER_GRAPH_ROUTE = "category-browser-graph"
private const val CATEGORY_BROWSER_DEEPLINK = "$ROOT_DEEPLINK/category-browser"

fun NavGraphBuilder.categoryBrowserGraph(
    navController: NavController,
    onFinalCategoryClick: (categoryId: String) -> Unit,
) {

    fun onCategoryClick(categoryId: String, isFinal: Boolean) {
        if (isFinal) {
            onFinalCategoryClick(categoryId)
        } else {
            navController.navigateToSubcategoryList(categoryId)
        }
    }

    navigation(
        startDestination = CATEGORY_LIST_ROUTE,
        route = CATEGORY_BROWSER_GRAPH_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = CATEGORY_BROWSER_DEEPLINK }
        ),
        enterTransition = { screenFadeIn() },
        exitTransition = { screenFadeOut() },
        popEnterTransition = { screenFadeIn() },
        popExitTransition = { screenFadeOut() },
    ) {
        categoryListScreen(
            onCategoryClick = ::onCategoryClick,
        )
        subcategoryListScreen(
            onBackClick = {
                navController.popBackStack()
            },
            onCategoryClick = ::onCategoryClick,
        )
    }
}
