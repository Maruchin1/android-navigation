@file:OptIn(ExperimentalMaterial3Api::class)

package com.maruchin.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllProductsButton(onClick: () -> Unit) {
    OutlinedCard(
        modifier = Modifier
            .width(150.dp)
            .padding(8.dp),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f / 1f),
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