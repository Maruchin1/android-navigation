package com.maruchin.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ProductItem(image: Int, title: String, price: Float, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .clickable { onClick() },
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedCard {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f / 1f),
                contentScale = ContentScale.Crop,
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