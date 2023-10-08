@file:OptIn(ExperimentalMaterial3Api::class)

package com.maruchin.features.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.maruchin.data.categories.Category
import com.maruchin.data.products.Product
import com.maruchin.data.products.sampleProducts
import java.net.URL

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
    Scaffold(
        topBar = {
            TopAppBar()
        },
        content = { padding ->
            CategoryProductsList(
                products = products,
                modifier = Modifier.padding(padding),
                onShowAllFromCategory = onShowAllFromCategory,
                onShowProduct = onShowProduct,
            )
        }
    )
}

@Composable
private fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Home")
        },
        actions = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Login")
            }
        }
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

@Composable
private fun ProductItem(image: URL, title: String, price: Float, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .clickable { onClick() },
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedCard {
            AsyncImage(
                model = image.toString(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 4f)
                    .padding(12.dp)
            )
        }
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = price.toString(),
            style = MaterialTheme.typography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
private fun AllProductsButton(onClick: () -> Unit) {
    OutlinedCard(modifier = Modifier.width(150.dp), onClick = onClick) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3f / 4f),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Show all",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.alpha(0.5f)
            )
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