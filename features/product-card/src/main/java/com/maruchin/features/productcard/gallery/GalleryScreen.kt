@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package com.maruchin.features.productcard.gallery

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import java.net.URL

@Composable
internal fun GalleryScreen(images: List<URL>, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(onBack = onBack)
        }
    ) { padding ->
        val pagerState = rememberPagerState { images.size }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Pager(images = images, pagerState = pagerState)
            PagerIndicator(pageCount = images.size, currentPage = pagerState.currentPage)
        }
    }
}

@Composable
private fun TopAppBar(onBack: () -> Unit) {
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }
        }
    )
}

@Composable
private fun BoxScope.Pager(images: List<URL>, pagerState: PagerState) {
    OutlinedCard(
        modifier = Modifier
            .padding(12.dp)
            .align(Alignment.Center)
    ) {
        HorizontalPager(state = pagerState) { page ->
            ProductImage(image = images[page])
        }
    }
}

@Composable
private fun BoxScope.PagerIndicator(pageCount: Int, currentPage: Int) {
    Row(
        modifier = Modifier.align(Alignment.BottomCenter),
        horizontalArrangement = Arrangement.Center,
    ) {
        repeat(pageCount) { page ->
            PageIndicator(isCurrent = page == currentPage)
        }
    }
}

@Composable
private fun PageIndicator(isCurrent: Boolean) {
    val color = if (isCurrent) Color.DarkGray else Color.LightGray

    Box(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 16.dp)
            .size(12.dp)
            .clip(CircleShape)
            .background(color)
    )
}

@Composable
private fun ProductImage(image: URL) {
    AsyncImage(
        model = image.toString(),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .aspectRatio(3f / 4f)
    )
}

@Preview
@Composable
private fun GalleryScreenPreview() {
    MaterialTheme {
        GalleryScreen(
            images = emptyList(),
            onBack = {},
        )
    }
}