@file:OptIn(ExperimentalMaterial3Api::class)

package com.maruchin.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.maruchin.core.ui.AllProductsButton
import com.maruchin.core.ui.ProductItem
import com.maruchin.data.categories.Category
import com.maruchin.data.products.Product
import com.maruchin.data.products.sampleProducts

@Composable
internal fun HomeScreen(
    onShowAllFromCategory: (Category) -> Unit,
    onShowProduct: (Product) -> Unit
) {
    val viewModel: HomeViewModel = hiltViewModel()
    HomeScreen(
        products = viewModel.products,
        onShowAllFromCategory = onShowAllFromCategory,
        onShowProduct = onShowProduct,
    )
}

@Composable
private fun HomeScreen(
    products: Map<Category, List<Product>>,
    onShowAllFromCategory: (Category) -> Unit,
    onShowProduct: (Product) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(scrollBehavior = scrollBehavior)
        },
        content = { padding ->
            CategoryProductsList(
                products = products,
                modifier = Modifier
                    .padding(padding)
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                onShowAllFromCategory = onShowAllFromCategory,
                onShowProduct = onShowProduct,
            )
        }
    )
}

@Composable
private fun TopAppBar(scrollBehavior: TopAppBarScrollBehavior) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Home")
        },
        actions = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Login")
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@Composable
private fun CategoryProductsList(
    products: Map<Category, List<Product>>,
    onShowAllFromCategory: (Category) -> Unit,
    onShowProduct: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(32.dp),
    ) {
        items(products.entries.toList()) { (category, products) ->
            Column {
                CategoryHeadline(name = category.name)
                ProductRow(
                    products = products,
                    onShowAll = { onShowAllFromCategory(category) },
                    onShowProduct = onShowProduct,
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
    onShowAll: () -> Unit,
    onShowProduct: (Product) -> Unit
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
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
        item {
            AllProductsButton(onClick = onShowAll)
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            products = sampleProducts.groupBy { it.category },
            onShowAllFromCategory = {},
            onShowProduct = {},
        )
    }
}