@file:OptIn(ExperimentalMaterial3Api::class)

package com.maruchin.features.productbrowser.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.maruchin.data.categories.Category
import com.maruchin.data.categories.sampleCategories

@Composable
internal fun CategoriesScreen(onShowCategory: (Category) -> Unit) {
    val viewModel: CategoriesViewModel = hiltViewModel()
    CategoriesScreen(categories = viewModel.categories, onShowCategory = onShowCategory)
}

@Composable
private fun CategoriesScreen(categories: List<Category>, onShowCategory: (Category) -> Unit) {
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
        }
    )
}

@Composable
private fun CategoryList(
    modifier: Modifier,
    categories: List<Category>,
    onShowCategory: (Category) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(categories) { category ->
            CategoryItem(category = category, onShowCategory = onShowCategory)
            Divider()
        }
    }
}

@Composable
private fun CategoryItem(category: Category, onShowCategory: (Category) -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onShowCategory(category) }
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = category.name.replaceFirstChar { it.titlecase() },
            style = MaterialTheme.typography.bodyLarge
        )
        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
    }
}

@Preview
@Composable
private fun CategoriesScreenPreview() {
    MaterialTheme {
        CategoriesScreen(categories = sampleCategories, onShowCategory = {})
    }
}