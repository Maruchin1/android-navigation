package com.maruchin.androidnavigation.navigationbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.maruchin.features.categorybrowser.CATEGORY_BROWSER_GRAPH_ROUTE
import com.maruchin.features.home.HOME_GRAPH_ROUTE

@Composable
internal fun NavigationBar(navController: NavController) {
    val state = rememberNavigationBarState(navController)

    NavigationBar {
        NavigationBarItem(
            selected = state.isRouteSelected(HOME_GRAPH_ROUTE)
                .collectAsState(initial = false)
                .value,
            onClick = {
                state.openRoute(HOME_GRAPH_ROUTE)
            },
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            }
        )
        NavigationBarItem(
            selected = state.isRouteSelected(CATEGORY_BROWSER_GRAPH_ROUTE)
                .collectAsState(initial = false)
                .value,
            onClick = {
                state.openRoute(CATEGORY_BROWSER_GRAPH_ROUTE)
            },
            icon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(imageVector = Icons.Default.ShoppingBag, contentDescription = null)
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)
            }
        )
    }
}

@Preview
@Composable
private fun NavigationBarPreview() {
    MaterialTheme {
        NavigationBar(rememberNavController())
    }
}