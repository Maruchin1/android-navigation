package com.maruchin.features.productbrowser.filters

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.data.products.ProductFilters

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun FiltersScreen(
    filters: ProductFilters,
    onBack: () -> Unit,
    onSortingChange: (ProductFilters.Sorting) -> Unit,
    onPriceChange: (ProductFilters.Price) -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Filtry")
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                SortingSection(filters = filters, onSortingChange = onSortingChange)
            }
            item {
                PriceRangeSection()
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SortingSection(
    filters: ProductFilters,
    onSortingChange: (ProductFilters.Sorting) -> Unit
) {
    Text(text = "Sorting", style = MaterialTheme.typography.titleMedium)
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ProductFilters.Sorting.values().forEach { sorting ->
            FilterChip(
                selected = filters.sorting == sorting,
                onClick = { onSortingChange(sorting) },
                label = {
                    Text(text = sorting.toText())
                }
            )
        }
    }
}

@Composable
private fun PriceRangeSection() {
    Text(text = "Price range", style = MaterialTheme.typography.titleMedium)
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "From")
            },
            modifier = Modifier.weight(1f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "To")
            },
            modifier = Modifier.weight(1f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
    }
}

private fun ProductFilters.Sorting.toText(): String {
    return when (this) {
        ProductFilters.Sorting.ALPHABETICALLY -> "Alphabetically"
        ProductFilters.Sorting.PRICE_FROM_THE_LOWEST -> "Price - from the lowest"
        ProductFilters.Sorting.PRICE_FROM_THE_HIGHEST -> "Price - from the highest"
    }
}

@Preview
@Composable
private fun FiltersScreenPreview() {
    MaterialTheme {
        FiltersScreen(
            filters = ProductFilters(),
            onBack = {},
            onSortingChange = {},
            onPriceChange = {}
        )
    }
}