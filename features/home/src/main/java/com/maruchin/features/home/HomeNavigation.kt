package com.maruchin.features.home

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val HOME_ROUTE = "home"

internal fun NavGraphBuilder.homeScreen(
    onCategoryClick: (categoryId: String) -> Unit,
    onProductClick: (productId: String) -> Unit,
    onLoginClick: () -> Unit,
) {
    composable(route = HOME_ROUTE) {
        val viewModel: HomeViewModel = hiltViewModel()
        val categories by viewModel.categories.collectAsState()
        val canLogin by viewModel.canLogin.collectAsState()

        HomeScreen(
            categories = categories,
            canLogin = canLogin,
            onCategoryClick = onCategoryClick,
            onProductClick = onProductClick,
            onLoginClick = onLoginClick,
        )
    }
}