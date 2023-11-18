package com.maruchin.features.productcard.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.data.products.Product
import com.maruchin.data.products.Rating
import com.maruchin.data.products.sampleProducts
import com.maruchin.features.productcard.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CardScreen(
    product: Product?,
    onBackClick: () -> Unit,
    onGalleryClick: () -> Unit,
    onAddToCartClick: () -> Unit,
    onFavoriteClick: () -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(scrollBehavior = scrollBehavior, onBackClick = onBackClick)
        }
    ) { padding ->
        if (product == null) return@Scaffold

        Content(
            product = product,
            modifier = Modifier
                .padding(padding)
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            onGalleryClick = onGalleryClick,
            onAddToCartClick = onAddToCartClick,
            onFavoriteClick = onFavoriteClick
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBar(scrollBehavior: TopAppBarScrollBehavior, onBackClick: () -> Unit) {
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = onBackClick) {
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
    onGalleryClick: () -> Unit,
    onAddToCartClick: () -> Unit,
    onFavoriteClick: () -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            ProductImage(image = product.images.first(), onOpenGallery = onGalleryClick)
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
            AddToCartSection(
                isFavorite = product.isFavorite,
                onAddToCartClick = onAddToCartClick,
                onFavoriteClick = onFavoriteClick
            )
        }
        item {
            Description(description = product.description)
        }
    }
}

@Composable
private fun AddToCartSection(
    isFavorite: Boolean,
    onAddToCartClick: () -> Unit,
    onFavoriteClick: () -> Unit,
) {
    Row {
        OutlinedButton(onClick = onAddToCartClick, modifier = Modifier.weight(1f)) {
            Text(text = stringResource(R.string.add_to_cart))
        }
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedButton(onClick = onFavoriteClick) {
            Icon(
                imageVector = if (isFavorite) {
                    Icons.Default.Favorite
                } else {
                    Icons.Default.FavoriteBorder
                },
                contentDescription = null
            )
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
private fun PriceText(price: Double) {
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
            product = sampleProducts.first(),
            onBackClick = {},
            onGalleryClick = {},
            onAddToCartClick = {},
            onFavoriteClick = {},
        )
    }
}