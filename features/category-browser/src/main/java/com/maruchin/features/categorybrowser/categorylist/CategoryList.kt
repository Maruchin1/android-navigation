package com.maruchin.features.categorybrowser.categorylist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.data.categories.Category

@Composable
internal fun CategoryList(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    onShowCategory: (Category) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(categories) { category ->
            CategoryItem(name = category.name, onClick = { onShowCategory(category) })
            Divider()
        }
    }
}

@Composable
private fun CategoryItem(name: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = name.replaceFirstChar { it.titlecase() },
            style = MaterialTheme.typography.bodyLarge
        )
        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
    }
}