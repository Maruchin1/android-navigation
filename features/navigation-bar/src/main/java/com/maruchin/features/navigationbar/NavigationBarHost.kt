package com.maruchin.features.navigationbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maruchin.features.categorybrowser.categoryBrowserGraph
import com.maruchin.features.home.HOME_GRAPH_ROUTE
import com.maruchin.features.home.homeGraph
import com.maruchin.features.productbrowser.navigateToProductBrowserGraph
import com.maruchin.features.productbrowser.productBrowserGraph
import com.maruchin.features.productcard.navigateToProductCardGraph
import com.maruchin.features.productcard.productCardGraph

@Composable
fun NavigationBarHost() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar(navController)
        }
    ) { padding ->
        NavHost(navController, HOME_GRAPH_ROUTE, modifier = Modifier.padding(padding)) {
            homeGraph(
                navController = navController,
                onShowProductsFromCategory = { category ->
                    navController.navigateToProductBrowserGraph(category.name)
                },
                onShowProduct = { product ->
                    navController.navigateToProductCardGraph(product.id)
                }
            )
            categoryBrowserGraph(
                navController = navController,
                onShowCategory = { category ->
                    navController.navigateToProductBrowserGraph(category.name)
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
