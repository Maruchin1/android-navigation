package com.maruchin.features.categorybrowser.categorylist

import androidx.compose.runtime.Immutable
import com.maruchin.data.categories.Category

@Immutable
internal data class CategoryListUiState(
    val categories: List<Category> = emptyList(),
)
