package com.maruchin.features.categorybrowser.subcategorylist

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maruchin.data.categories.Category
import com.maruchin.data.categories.sampleCategories
import com.maruchin.features.categorybrowser.categorylist.CategoryList

@Composable
internal fun SubcategoryListScreen(
    category: Category?,
    onBackClick: () -> Unit,
    onCategoryClick: (categoryId: String, isFinal: Boolean) -> Unit
) {
    if (category == null) return

    Scaffold(
        topBar = {
            TopBar(categoryName = category.name, onBackClick = onBackClick)
        }
    ) { padding ->
        CategoryList(
            modifier = Modifier.padding(padding),
            categories = category.subcategories,
            onCategoryClick = onCategoryClick,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(categoryName: String, onBackClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = categoryName)
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        }
    )
}

@Preview
@Composable
private fun SubcategoryListScreenPreview() {
    SubcategoryListScreen(
        category = sampleCategories[1],
        onBackClick = {},
        onCategoryClick = { _, _ -> }
    )
}