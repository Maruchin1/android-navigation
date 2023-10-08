@file:OptIn(ExperimentalMaterial3Api::class)

package com.maruchin.features.productcard.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.maruchin.data.products.Product
import com.maruchin.data.products.Rating
import com.maruchin.data.products.sampleProducts
import java.net.URL

@Composable
internal fun CardScreen(onBack: () -> Unit, onOpenGallery: (Product) -> Unit) {
    val viewModel: CardViewModel = hiltViewModel()
    CardScreen(
        product = viewModel.product,
        onBack = onBack,
        onOpenGallery = {
            viewModel.product?.let(onOpenGallery)
        }
    )
}

@Composable
private fun CardScreen(product: Product?, onBack: () -> Unit, onOpenGallery: () -> Unit) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        topBar = {
            TopAppBar(scrollBehavior = scrollBehavior, onBack = onBack)
        }
    ) { padding ->
        if (product != null) {
            Content(
                product = product,
                modifier = Modifier
                    .padding(padding)
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                onOpenGallery = onOpenGallery
            )
        }
    }
}

@Composable
private fun TopAppBar(scrollBehavior: TopAppBarScrollBehavior, onBack: () -> Unit) {
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@Composable
private fun Content(product: Product, modifier: Modifier, onOpenGallery: () -> Unit) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            Image(image = product.images.first(), onOpenGallery = onOpenGallery)
        }
        item {
            TitleText(product)
        }
        item {
            PriceText(product)
        }
        item {
            RatingStars(stars = product.rating.stars, ratingCount = product.rating.count)
        }
        item {
            Description(description = product.description)
        }
    }
}

@Composable
private fun Image(image: URL, onOpenGallery: () -> Unit) {
    OutlinedCard(onClick = onOpenGallery) {
        AsyncImage(
            model = image.toString(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3f / 4f)
                .padding(24.dp)
        )
    }
}

@Composable
private fun TitleText(product: Product) {
    Text(text = product.title, style = MaterialTheme.typography.headlineMedium)
}

@Composable
private fun PriceText(product: Product) {
    Text(text = product.price.toString(), style = MaterialTheme.typography.titleLarge)
}

@Composable
private fun RatingStars(stars: List<Rating.STAR>, ratingCount: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        stars.map {
            Icon(
                imageVector = when (it) {
                    Rating.STAR.STAR -> Icons.Default.Star
                    Rating.STAR.HALF_STAR -> Icons.Default.StarHalf
                    Rating.STAR.EMPTY_STAR -> Icons.Default.StarOutline
                },
                contentDescription = null
            )
        }
        Text(
            text = "$ratingCount reviews",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Composable
private fun Description(description: String) {
    Text(
        text = description,
        style = MaterialTheme.typography.bodyLarge,
        textAlign = TextAlign.Justify
    )
}

@Preview
@Composable
private fun CardScreenPreview() {
    MaterialTheme {
        CardScreen(product = sampleProducts[0], onBack = {}, onOpenGallery = {})
    }
}