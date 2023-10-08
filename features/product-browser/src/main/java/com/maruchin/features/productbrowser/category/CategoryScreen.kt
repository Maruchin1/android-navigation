@file:OptIn(ExperimentalMaterial3Api::class)

package com.maruchin.features.productbrowser.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.core.ui.ProductItem
import com.maruchin.data.categories.Category
import com.maruchin.data.categories.sampleCategories
import com.maruchin.data.products.Product
import com.maruchin.data.products.sampleProducts

@Composable
internal fun CategoryScreen(
    category: Category?,
    products: List<Product>,
    onBack: () -> Unit,
    onShowProduct: (Product) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(category = category, onBack = onBack)
        }
    ) { padding ->
        ProductGrid(
            modifier = Modifier.padding(padding),
            products = products,
            onShowProduct = onShowProduct
        )
    }
}

@Composable
private fun TopAppBar(category: Category?, onBack: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = category?.name?.replaceFirstChar { it.titlecase() } ?: "")
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        }
    )
}

@Composable
private fun ProductGrid(
    modifier: Modifier,
    products: List<Product>,
    onShowProduct: (Product) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(12.dp)
    ) {
        items(products) { product ->
            ProductItem(
                image = product.images.first(),
                title = product.title,
                price = product.price,
                onClick = { onShowProduct(product) }
            )
        }
    }
}

@Preview
@Composable
private fun CategoryScreenPreview() {
    MaterialTheme {
        CategoryScreen(
            category = sampleCategories.first(),
            products = sampleProducts,
            onBack = {},
            onShowProduct = {}
        )
    }
}