package com.maruchin.features.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.core.ui.OrderProductItem
import com.maruchin.data.cart.sampleCart
import com.maruchin.data.products.ProductId

@Composable
internal fun CartScreen(
    state: CartUiState,
    onNextClick: () -> Unit,
    onProductClick: (ProductId) -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(
                totalPrice = state.totalPrice,
                onNextClick = onNextClick
            )
        }
    ) { padding ->
        ProductList(
            products = state.products,
            modifier = Modifier.padding(padding),
            onProductClick = onProductClick,
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.cart))
        }
    )
}

@Composable
private fun BottomBar(
    totalPrice: Double,
    onNextClick: () -> Unit
) {
    Column(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) {
        Divider()
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                TotalPriceLabel()
                TotalPriceText(totalPrice = totalPrice)
            }
            AddPromoCodeButton()
        }
        NextButton(onClick = onNextClick)
    }
}

@Composable
private fun TotalPriceLabel() {
    Text(
        text = stringResource(R.string.total_to_be_paid),
        style = MaterialTheme.typography.titleSmall,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
    )
}

@Composable
private fun TotalPriceText(totalPrice: Double) {
    Text(
        text = "$ $totalPrice",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
    )
}

@Composable
private fun AddPromoCodeButton() {
    TextButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(text = stringResource(R.string.add_promo_code))
    }
}

@Composable
private fun NextButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = stringResource(R.string.next))
    }
}

@Composable
private fun ProductList(
    products: List<CartProductUiState>,
    modifier: Modifier = Modifier,
    onProductClick: (ProductId) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        items(products) { product ->
            OrderProductItem(
                image = product.image,
                name = product.name,
                price = product.price,
                quantity = product.quantity,
                onClick = { onProductClick(product.id) },
                onDeleteClick = {},
                onQuantityClick = {},
            )
        }
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    CartScreen(
        state = createCartUiState(sampleCart),
        onNextClick = {},
        onProductClick = {},
    )
}