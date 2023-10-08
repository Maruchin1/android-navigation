package com.maruchin.features.navigationbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maruchin.features.home.HOME_GRAPH_ROUTE
import com.maruchin.features.home.homeGraph
import com.maruchin.features.productbrowser.category.deeplinkToCategory
import com.maruchin.features.productbrowser.productBrowserGraph

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
                onShowAllFromCategory = { category ->
                    navController.deeplinkToCategory(category.name)
                }
            )
            productBrowserGraph(navController)
        }
    }
}
