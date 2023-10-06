@file:OptIn(ExperimentalMaterial3Api::class)

package com.maruchin.features.home

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.maruchin.data.categories.Category
import com.maruchin.data.products.Product
import com.maruchin.data.products.sampleProducts

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    HomeScreen(products = viewModel.products)
}

@Composable
internal fun HomeScreen(products: Map<Category, List<Product>>) {
    Scaffold(
        topBar = {
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
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                items(products.entries.toList()) { (category, products) ->
                    Column {
                        Text(
                            text = category.name,
                            modifier = Modifier.padding(12.dp),
                            style = MaterialTheme.typography.titleLarge
                        )
                        LazyRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            contentPadding = PaddingValues(12.dp)
                        ) {
                            items(products) { product ->
                                ProductItem(product = product)
                            }
                        }
                    }
                }
            }
        }
    )
}

@Composable
private fun ProductItem(product: Product) {
    Card(modifier = Modifier.width(100.dp)) {
        AsyncImage(
            model = product.image.toString(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3f / 4f)
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            products = sampleProducts.groupBy { it.category }
        )
    }
}