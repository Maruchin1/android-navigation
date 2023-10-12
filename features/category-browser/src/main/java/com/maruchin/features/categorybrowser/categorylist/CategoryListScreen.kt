@file:OptIn(ExperimentalMaterial3Api::class)

package com.maruchin.features.categorybrowser.categorylist

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maruchin.data.categories.Category
import com.maruchin.data.categories.sampleCategories

@Composable
internal fun CategoryListScreen(
    categories: List<Category>,
    onShowCategory: (Category) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) { padding ->
        CategoryList(
            categories = categories,
            modifier = Modifier.padding(padding),
            onShowCategory = onShowCategory
        )
    }
}

@Composable
private fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Categories")
        },
    )
}

@Preview
@Composable
private fun CategoriesScreenPreview() {
    MaterialTheme {
        CategoryListScreen(categories = sampleCategories, onShowCategory = {})
    }
}