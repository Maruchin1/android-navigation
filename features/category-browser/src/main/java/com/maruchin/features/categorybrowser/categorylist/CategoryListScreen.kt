package com.maruchin.features.categorybrowser.categorylist

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maruchin.data.categories.Category
import com.maruchin.data.categories.sampleCategories
import com.maruchin.features.categorybrowser.R

@Composable
internal fun CategoryListScreen(
    categories: List<Category>,
    onCategoryClick: (categoryId: String, isFinal: Boolean) -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar()
        }
    ) { padding ->
        CategoryList(
            categories = categories,
            modifier = Modifier.padding(padding),
            onCategoryClick = onCategoryClick,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.categories))
        },
    )
}

@Preview
@Composable
private fun CategoriesScreenPreview() {
    MaterialTheme {
        CategoryListScreen(
            categories = sampleCategories,
            onCategoryClick = { _, _ -> },
        )
    }
}