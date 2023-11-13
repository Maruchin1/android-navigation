package com.maruchin.features.cart.cart

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.data.cart.sampleCart
import com.maruchin.data.products.ProductId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CartScreen(
    state: CartUiState,
    onNextClick: () -> Unit,
    onProductClick: (ProductId) -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Cart")
                }
            )
        },
        bottomBar = {
            Column(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) {
                Divider()
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column {
                        Text(
                            text = "Total to be paid",
                            style = MaterialTheme.typography.titleSmall,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                        )
                        Text(
                            text = "${state.cart?.totalPrice}",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                        )
                    }
                    TextButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        Text(text = "Add promo code")
                    }
                }
                Button(
                    onClick = onNextClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Next")
                }
            }
        }
    ) { padding ->
        if (state.cart == null) return@Scaffold
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(state.cart.products) { item ->
                CartProductItem(
                    image = item.product.images.first(),
                    name = item.product.name,
                    price = item.product.price,
                    quantity = item.quantity,
                    onClick = { onProductClick(item.product.id) },
                    onDeleteClick = { /*TODO*/ },
                    onQuantityClick = {},
                )
            }
        }
    }
}

@Composable
private fun CartProductItem(
    @DrawableRes image: Int,
    name: String,
    price: Float,
    quantity: Int,
    onClick: () -> Unit,
    onQuantityClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        OutlinedCard(modifier = Modifier.weight(1f)) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(2f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = name, style = MaterialTheme.typography.titleMedium)
            Text(text = "$price")
            Row {
                AssistChip(
                    onClick = onQuantityClick,
                    label = {
                        Text(text = "x$quantity")
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                AssistChip(
                    onClick = onDeleteClick,
                    label = {
                        Text(text = "Delete")
                    },
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                    }
                )
            }
        }
    }
    Divider(modifier = Modifier.padding(horizontal = 16.dp))
}

@Preview
@Composable
private fun CartScreenPreview() {
    CartScreen(
        state =  CartUiState(cart = sampleCart),
        onNextClick = {},
        onProductClick = {},
    )
}