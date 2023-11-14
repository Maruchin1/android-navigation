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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maruchin.core.ui.ProductItem
import com.maruchin.data.products.ProductId
import com.maruchin.data.products.sampleFavoriteProducts

@Composable
internal fun FavoritesScreen(
    state: FavoritesUiState,
    onProductClick: (ProductId) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar()
        }
    ) { padding ->
        ProductGrid(
            products = state.products,
            modifier = Modifier.padding(padding),
            onProductClick = onProductClick,
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.favorites))
        }
    )
}

@Composable
private fun ProductGrid(
    products: List<ProductUiState>,
    modifier: Modifier = Modifier,
    onProductClick: (ProductId) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
    ) {
        items(products) { product ->
            ProductItem(
                image = product.image,
                title = product.name,
                price = product.price,
                isFavorite = product.isFavorite,
                onClick = {
                    onProductClick(product.id)
                }
            )
        }
    }
}

@Preview
@Composable
private fun FavoritesScreenPreview() {
    FavoritesScreen(
        state = createFavoritesUiState(sampleFavoriteProducts),
        onProductClick = {},
    )
}