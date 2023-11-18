package com.maruchin.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.ui.AllProductsButton
import com.maruchin.ui.ProductItem
import com.maruchin.data.categories.Category
import com.maruchin.data.products.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(
    categories: Map<Category, List<Product>>,
    canLogin: Boolean,
    onCategoryClick: (categoryId: String) -> Unit,
    onProductClick: (productId: String) -> Unit,
    onLoginClick: () -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            TopBar(
                canLogin = canLogin,
                scrollBehavior = scrollBehavior,
                onLoginClick = onLoginClick
            )
        },
        content = { padding ->
            CategoryProductsList(
                categories = categories,
                modifier = Modifier
                    .padding(padding)
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                onCategoryClick = onCategoryClick,
                onProductClick = onProductClick,
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    canLogin: Boolean,
    scrollBehavior: TopAppBarScrollBehavior,
    onLoginClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.home))
        },
        actions = {
            if (canLogin) {
                TextButton(onClick = onLoginClick) {
                    Text(text = stringResource(R.string.login))
                }
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@Composable
private fun CategoryProductsList(
    categories: Map<Category, List<Product>>,
    modifier: Modifier = Modifier,
    onCategoryClick: (categoryId: String) -> Unit,
    onProductClick: (productId: String) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(32.dp),
    ) {
        items(categories.entries.toList()) { (category, products) ->
            Column {
                CategoryHeadline(name = category.name)
                ProductRow(
                    products = products,
                    onShowAllClick = { onCategoryClick(category.id) },
                    onProductClick = onProductClick,
                )
            }
        }
    }
}

@Composable
private fun CategoryHeadline(name: String) {
    Text(
        text = name.replaceFirstChar { it.titlecase() },
        modifier = Modifier.padding(12.dp),
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
private fun ProductRow(
    products: List<Product>,
    onShowAllClick: () -> Unit,
    onProductClick: (productId: String) -> Unit
) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(products) { product ->
            ProductItem(
                image = product.images.first(),
                title = product.name,
                price = product.price,
                isFavorite = product.isFavorite,
                onClick = { onProductClick(product.id) }
            )
        }
        item {
            AllProductsButton(onClick = onShowAllClick)
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            categories = emptyMap(),
            canLogin = true,
            onCategoryClick = {},
            onProductClick = {},
            onLoginClick = {}
        )
    }
}