package com.maruchin.features.navigationbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Stable
internal class NavigationBarState(private val navController: NavController) {

    fun isRouteSelected(route: String): Flow<Boolean> {
        return navController.currentBackStackEntryFlow.map { entry ->
            entry.destination.hierarchy.any { it.route == route }
        }
    }

    fun openRoute(route: String) {
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

@Composable
internal fun rememberNavigationBarState(navController: NavController): NavigationBarState {
    return remember(navController) {
        NavigationBarState(navController)
    }
}