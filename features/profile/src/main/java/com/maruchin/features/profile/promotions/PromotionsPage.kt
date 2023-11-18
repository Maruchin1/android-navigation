package com.maruchin.features.profile.promotions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.maruchin.data.promotions.Promotion
import com.maruchin.data.promotions.samplePromotions
import java.net.URL

@Composable
internal fun PromotionsPage(onPromotionClick: (promotionId: String) -> Unit) {
    val viewModel: PromotionsViewModel = hiltViewModel()
    val promotions by viewModel.promotions.collectAsState()

    PromotionsPage(promotions = promotions, onPromotionClick = onPromotionClick)
}

@Composable
private fun PromotionsPage(
    promotions: List<Promotion>,
    onPromotionClick: (promotionId: String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(promotions) { promotion ->
            PromotionItem(
                image = promotion.image,
                onClick = { onPromotionClick(promotion.id) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PromotionItem(image: URL, onClick: () -> Unit) {
    Card(onClick = onClick) {
        AsyncImage(
            model = image.toString(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4f / 3f),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PromotionsPagePreview() {
    PromotionsPage(promotions = samplePromotions, onPromotionClick = {})
}
