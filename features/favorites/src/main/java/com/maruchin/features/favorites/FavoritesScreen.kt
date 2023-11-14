package com.maruchin.features.favorites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maruchin.core.ui.ProductItem
import com.maruchin.data.products.Product
import com.maruchin.data.products.sampleFavoriteProducts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun FavoritesScreen(state: FavoritesUiState, onProductClick: (Product) -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Favorites")
                }
            )
        }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            items(state.products) { product ->
                ProductItem(
                    image = product.images.first(),
                    title = product.name,
                    price = product.price,
                    isFavorite = product.isFavorite,
                    onClick = {
                        onProductClick(product)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun FavoritesScreenPreview() {
    FavoritesScreen(
        state = FavoritesUiState(
            products = sampleFavoriteProducts
        ),
        onProductClick = {},
    )
}