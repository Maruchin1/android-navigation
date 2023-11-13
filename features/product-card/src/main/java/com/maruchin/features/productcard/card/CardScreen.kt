package com.maruchin.features.productcard.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
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
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.data.products.Product
import com.maruchin.data.products.Rating
import com.maruchin.data.products.sampleProducts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CardScreen(
    state: CardUiState,
    onBack: () -> Unit,
    onOpenGallery: () -> Unit,
    onAddToCart: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        topBar = {
            TopAppBar(scrollBehavior = scrollBehavior, onBack = onBack)
        }
    ) { padding ->
        if (state.product == null) return@Scaffold
        Content(
            product = state.product,
            modifier = Modifier
                .padding(padding)
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            onOpenGallery = onOpenGallery,
            onAddToCart = onAddToCart,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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
private fun Content(
    product: Product,
    modifier: Modifier,
    onOpenGallery: () -> Unit,
    onAddToCart: () -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            ProductImage(image = product.images.first(), onOpenGallery = onOpenGallery)
        }
        item {
            TitleText(text = product.name)
        }
        item {
            PriceText(price = product.price)
        }
        item {
            RatingStars(stars = product.rating.stars, ratingCount = product.rating.count)
        }
        item {
            OutlinedButton(onClick = onAddToCart, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Add to cart")
            }
        }
        item {
            Description(description = product.description)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductImage(@DrawableRes image: Int, onOpenGallery: () -> Unit) {
    OutlinedCard(onClick = onOpenGallery) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f / 1f)
        )
    }
}

@Composable
private fun TitleText(text: String) {
    Text(text = text, style = MaterialTheme.typography.headlineMedium)
}

@Composable
private fun PriceText(price: Float) {
    Text(text = price.toString(), style = MaterialTheme.typography.titleLarge)
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
        CardScreen(
            state = CardUiState(product = sampleProducts.first()),
            onBack = {},
            onOpenGallery = {},
            onAddToCart = {}
        )
    }
}