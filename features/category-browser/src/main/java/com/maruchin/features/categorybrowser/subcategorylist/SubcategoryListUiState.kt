package com.maruchin.features.categorybrowser.subcategorylist

import com.maruchin.data.categories.Category
import com.maruchin.features.categorybrowser.categorylist.CategoryUiState
import com.maruchin.features.categorybrowser.categorylist.createCategoryUiState

internal data class SubcategoryListUiState(
    val name: String = "",
    val subcategories: List<CategoryUiState> = emptyList(),
)

internal fun createSubcategoryListUiState(category: Category) = SubcategoryListUiState(
    name = category.name,
    subcategories = category.subcategories.map(::createCategoryUiState)
)
