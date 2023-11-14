package com.maruchin.features.favorites

import androidx.compose.runtime.Immutable
import com.maruchin.data.products.Product

@Immutable
data class FavoritesUiState(
    val products: List<Product> = emptyList()
)