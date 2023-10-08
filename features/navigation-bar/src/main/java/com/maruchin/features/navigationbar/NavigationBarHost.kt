package com.maruchin.features.navigationbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maruchin.features.home.HOME_GRAPH
import com.maruchin.features.home.homeGraph

@Composable
fun NavigationBarHost() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar(navController)
        }
    ) { padding ->
        NavHost(navController, HOME_GRAPH, modifier = Modifier.padding(padding)) {
            homeGraph(navController)
        }
    }
}
