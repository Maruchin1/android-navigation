@file:OptIn(ExperimentalMaterial3Api::class)

package com.maruchin.features.productbrowser.productlist

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterList
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
import com.maruchin.ui.ProductGrid
import com.maruchin.data.categories.Category
import com.maruchin.data.categories.sampleCategories
import com.maruchin.data.products.Product

@Composable
internal fun ProductListScreen(
    category: Category?,
    products: List<Product>,
    onBackClick: () -> Unit,
    onProductClick: (productId: String) -> Unit,
    onFiltersClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                category = category,
                onBackClick = onBackClick,
                onFiltersClick = onFiltersClick
            )
        }
    ) { padding ->
        ProductGrid(
            modifier = Modifier.padding(padding),
            products = products,
            onShowProduct = onProductClick
        )
    }
}

@Composable
private fun TopAppBar(category: Category?, onBackClick: () -> Unit, onFiltersClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = category?.name?.replaceFirstChar { it.titlecase() } ?: "")
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = onFiltersClick) {
                Icon(imageVector = Icons.Default.FilterList, contentDescription = null)
            }
        }
    )
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    MaterialTheme {
        ProductListScreen(
            category = sampleCategories.first(),
            products = emptyList(),
            onBackClick = {},
            onProductClick = {},
            onFiltersClick = {},
        )
    }
}