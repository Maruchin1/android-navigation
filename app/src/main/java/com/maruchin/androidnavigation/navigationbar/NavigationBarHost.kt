package com.maruchin.androidnavigation.navigationbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maruchin.features.categorybrowser.categoryBrowserGraph
import com.maruchin.features.home.HOME_GRAPH_ROUTE
import com.maruchin.features.home.homeGraph
import com.maruchin.features.login.getLoginSuccess
import com.maruchin.features.productbrowser.navigateToProductBrowserGraph
import com.maruchin.features.productbrowser.productBrowserGraph
import com.maruchin.features.productcard.navigateToProductCardGraph
import com.maruchin.features.productcard.productCardGraph
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

internal const val NAVIGATION_BAR_HOST_ROUTE = "navigation_bar_host"

internal fun NavGraphBuilder.navigationBarHost(onLogin: () -> Unit) {
    composable(NAVIGATION_BAR_HOST_ROUTE) { entry ->
        val navController = rememberNavController()
        val snackbarHostState = remember { SnackbarHostState() }

        LaunchedEffect(entry) {
            entry.savedStateHandle.getLoginSuccess()
                .filter { it }
                .map { "Hello! Good to see you :)" }
                .collect(snackbarHostState::showSnackbar)
        }

        Scaffold(
            bottomBar = {
                NavigationBar(navController = navController)
            },
            snackbarHost = {
                SnackbarHost(snackbarHostState)
            }
        ) { padding ->
            NavHost(navController, HOME_GRAPH_ROUTE, modifier = Modifier.padding(padding)) {
                homeGraph(
                    navController = navController,
                    onShowProductsFromCategory = { category ->
                        navController.navigateToProductBrowserGraph(category.id)
                    },
                    onShowProduct = { product ->
                        navController.navigateToProductCardGraph(product.id)
                    },
                    onLogin = onLogin
                )
                categoryBrowserGraph(
                    navController = navController,
                    onShowCategory = { category ->
                        navController.navigateToProductBrowserGraph(category.id)
                    }
                )
                productBrowserGraph(
                    navController = navController,
                    onShowProduct = { product ->
                        navController.navigateToProductCardGraph(product.id)
                    }
                )
                productCardGraph(navController = navController)
            }
        }
    }
}
