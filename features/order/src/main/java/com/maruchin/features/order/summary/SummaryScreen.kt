package com.maruchin.features.order.summary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.core.ui.AddressItem
import com.maruchin.core.ui.DeliveryItem
import com.maruchin.core.ui.OrderProductItem
import com.maruchin.core.ui.PaymentItem
import com.maruchin.data.order.Order
import com.maruchin.data.order.sampleInProgressOrder
import com.maruchin.data.products.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SummaryScreen(
    state: SummaryUiState,
    onBackClick: () -> Unit,
    onProductClick: (Product) -> Unit,
    onSubmitOrderClick: () -> Unit,
    onCancelClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Summary")
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                        }
                    },
                    actions = {
                        TextButton(onClick = onCancelClick) {
                            Text(text = "Cancel")
                        }
                    }
                )
                LinearProgressIndicator(progress = 1f, modifier = Modifier.fillMaxWidth())
            }
        }
    ) { padding ->
        if (state.order !is Order.InProgress) return@Scaffold
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            Text(
                text = "Products",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
            state.order.products.forEach { product ->
                OrderProductItem(
                    image = product.product.images.first(),
                    name = product.product.name,
                    price = product.product.price,
                    quantity = product.quantity,
                    onClick = { onProductClick(product.product) },
                )
            }
            Text(
                text = "Delivery",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(16.dp)
                    .padding(top = 32.dp)
            )
            state.order.delivery?.let { delivery ->
                DeliveryItem(
                    logo = delivery.logo,
                    name = delivery.name,
                    price = delivery.price,
                    onClick = {}
                )
            }
            Text(
                text = "Address",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(16.dp)
                    .padding(top = 32.dp)
            )
            state.order.address?.let { address ->
                AddressItem(
                    firstName = address.firstName,
                    lastName = address.lastName,
                    street = address.street,
                    house = address.house,
                    apartment = address.apartment,
                    postalCode = address.postalCode,
                    city = address.city,
                )
            }
            Text(
                text = "Payment",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(16.dp)
                    .padding(top = 32.dp)
            )
            Row(
                modifier = Modifier.height(IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically
            ) {
                state.order.payment?.let { payment ->
                    PaymentItem(
                        logo = payment.logo,
                        modifier = Modifier
                            .padding(16.dp)
                            .weight(1f)
                    )
                }
                Text(
                    text = "$ ${state.order.totalPrice}",
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(2f),
                    textAlign = TextAlign.End,
                )
            }
            Button(
                onClick = onSubmitOrderClick,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Submit order")
            }
        }
    }
}

@Preview
@Composable
private fun SummaryScreenPreview() {
    SummaryScreen(
        state = SummaryUiState(order = sampleInProgressOrder),
        onBackClick = {},
        onProductClick = {},
        onSubmitOrderClick = {},
        onCancelClick = {},
    )
}
