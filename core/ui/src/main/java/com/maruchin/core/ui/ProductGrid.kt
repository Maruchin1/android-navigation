package com.maruchin.core.ui

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maruchin.data.products.Product

@Composable
fun ProductGrid(
    modifier: Modifier,
    products: List<Product>,
    onShowProduct: (productId: String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
    ) {
        items(products) { product ->
            ProductItem(
                image = product.images.first(),
                title = product.name,
                price = product.price,
                isFavorite = product.isFavorite,
                onClick = { onShowProduct(product.id) }
            )
        }
    }
}