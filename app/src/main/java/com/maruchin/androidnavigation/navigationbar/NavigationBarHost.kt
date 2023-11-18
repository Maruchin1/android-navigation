package com.maruchin.androidnavigation.navigationbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maruchin.features.cart.cartGraph
import com.maruchin.features.categorybrowser.categoryBrowserGraph
import com.maruchin.features.favorites.favoritesGraph
import com.maruchin.features.home.HOME_GRAPH_ROUTE
import com.maruchin.features.home.homeGraph
import com.maruchin.features.login.getLoginSuccess
import com.maruchin.features.mydata.myDataGraph
import com.maruchin.features.mydata.navigateToMyDataGraph
import com.maruchin.features.productbrowser.navigateToProductBrowserGraph
import com.maruchin.features.productbrowser.productBrowserGraph
import com.maruchin.features.productcard.navigateToProductCardGraph
import com.maruchin.features.productcard.productCardGraph
import com.maruchin.features.profile.navigateToProfileGraph
import com.maruchin.features.profile.profileGraph
import com.maruchin.ui.screenFadeIn
import com.maruchin.ui.screenFadeOut
import com.maruchin.ui.screenSlideIn
import com.maruchin.ui.screenSlideOut
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

internal const val NAVIGATION_BAR_HOST_ROUTE = "navigation_bar_host"

internal fun NavGraphBuilder.navigationBarHost(
    navController: NavHostController,
    onNavigateToLogin: () -> Unit,
    onNavigateToJoinClub: () -> Unit,
    onNavigateToOrder: () -> Unit,
) {
    composable(NAVIGATION_BAR_HOST_ROUTE) { entry ->
        val context = LocalContext.current
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
            NavHost(
                navController = navController,
                startDestination = HOME_GRAPH_ROUTE,
                modifier = Modifier.padding(padding),
                enterTransition = { screenSlideIn() },
                exitTransition = { screenFadeOut() },
                popEnterTransition = { screenFadeIn() },
                popExitTransition = { screenSlideOut() },
            ) {
                homeGraph(
                    onCategoryClick = { categoryId ->
                        navController.navigateToProductBrowserGraph(categoryId)
                    },
                    onProductClick = { productId ->
                        navController.navigateToProductCardGraph(productId)
                    },
                    onLoginClick = onNavigateToLogin
                )
                categoryBrowserGraph(
                    navController = navController,
                    onFinalCategoryClick = { categoryId ->
                        navController.navigateToProductBrowserGraph(categoryId)
                    }
                )
                favoritesGraph(
                    onProductClick = { productId ->
                        navController.navigateToProductCardGraph(productId)
                    }
                )
                cartGraph(
                    onNextClick = onNavigateToOrder,
                    onProductClick = { productId ->
                        navController.navigateToProductCardGraph(productId)
                    }
                )
                profileGraph(
                    navController = navController,
                    context = context,
                    onMyDataClick = {
                        navController.navigateToMyDataGraph()
                    },
                    onLoginClick = onNavigateToLogin,
                    onJoinClubClick = onNavigateToJoinClub,
                )
                productBrowserGraph(
                    navController = navController,
                    onShowProduct = { productId ->
                        navController.navigateToProductCardGraph(productId)
                    }
                )
                productCardGraph(navController = navController)
                myDataGraph(
                    navController = navController,
                    onNavigateToProfile = {
                        navController.navigateToProfileGraph()
                    }
                )
            }
        }
    }
}
