package com.maruchin.features.categorybrowser.categorylist

import com.maruchin.data.categories.Category
import com.maruchin.data.categories.CategoryId

internal data class CategoryListUiState(
    val categories: List<CategoryUiState> = emptyList(),
)

internal data class CategoryUiState(
    val id: CategoryId,
    val name: String,
    val isFinal: Boolean,
)

internal fun createCategoryListUiState(categories: List<Category>) = CategoryListUiState(
    categories = categories.map(::createCategoryUiState)
)

internal fun createCategoryUiState(category: Category) = CategoryUiState(
    id = category.id,
    name = category.name,
    isFinal = category.isFinal,
)
