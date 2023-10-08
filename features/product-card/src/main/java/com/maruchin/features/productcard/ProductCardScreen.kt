@file:OptIn(ExperimentalMaterial3Api::class)

package com.maruchin.features.productcard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.maruchin.data.products.Product
import com.maruchin.data.products.sampleProducts

@Composable
internal fun ProductCardScreen(onBack: () -> Unit) {
    val viewModel: ProductCardViewModel = hiltViewModel()
    ProductCardScreen(
        product = viewModel.product,
        onBack = onBack,
    )
}

@Composable
private fun ProductCardScreen(product: Product?, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
            )
        }
    ) { padding ->
        if (product != null) {
            Content(product = product, modifier = Modifier.padding(padding))
        }
    }
}

@Composable
private fun Content(product: Product, modifier: Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item {
            OutlinedCard {
                AsyncImage(
                    model = product.image.toString(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(3f / 4f)
                        .padding(24.dp)
                )
            }
        }
        item {
            Text(
                text = product.title,
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        item {
            Text(text = product.price.toString(), style = MaterialTheme.typography.titleLarge)
        }
        item {
            Text(
                text = product.description,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview
@Composable
private fun ProductCardScreenPreview() {
    MaterialTheme {
        ProductCardScreen(product = sampleProducts[0], onBack = {})
    }
}