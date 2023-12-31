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
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.maruchin.features.cart.CART_GRAPH_ROUTE
import com.maruchin.features.categorybrowser.CATEGORY_BROWSER_GRAPH_ROUTE
import com.maruchin.features.favorites.FAVORITES_GRAPH_ROUTE
import com.maruchin.features.home.HOME_GRAPH_ROUTE
import com.maruchin.features.profile.PROFILE_GRAPH_ROUTE

@Composable
internal fun NavigationBar(navController: NavController) {
    val state = rememberNavigationBarState(navController)

    NavigationBar {
        val isHomeSelected by state.isRouteSelected(HOME_GRAPH_ROUTE)
            .collectAsState(initial = false)
        NavigationBarItem(
            selected = isHomeSelected,
            onClick = {
                state.openRoute(HOME_GRAPH_ROUTE)
            },
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            }
        )

        val isCategoryBrowserSelected by state.isRouteSelected(CATEGORY_BROWSER_GRAPH_ROUTE)
            .collectAsState(initial = false)
        NavigationBarItem(
            selected = isCategoryBrowserSelected,
            onClick = {
                state.openRoute(CATEGORY_BROWSER_GRAPH_ROUTE)
            },
            icon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }
        )

        val isFavoritesSelected by state.isRouteSelected(FAVORITES_GRAPH_ROUTE)
            .collectAsState(initial = false)
        NavigationBarItem(
            selected = isFavoritesSelected,
            onClick = {
                state.openRoute(FAVORITES_GRAPH_ROUTE)
            },
            icon = {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
            }
        )

        val isCartSelected by state.isRouteSelected(CART_GRAPH_ROUTE)
            .collectAsState(initial = false)
        NavigationBarItem(
            selected = isCartSelected,
            onClick = {
                state.openRoute(CART_GRAPH_ROUTE)
            },
            icon = {
                Icon(imageVector = Icons.Default.ShoppingBag, contentDescription = null)
            }
        )

        val isProfileSelected by state.isRouteSelected(PROFILE_GRAPH_ROUTE)
            .collectAsState(initial = false)
        NavigationBarItem(
            selected = isProfileSelected,
            onClick = {
                state.openRoute(PROFILE_GRAPH_ROUTE)
            },
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