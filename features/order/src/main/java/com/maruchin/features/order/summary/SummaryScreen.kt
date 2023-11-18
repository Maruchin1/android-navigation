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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.ui.AddressItem
import com.maruchin.ui.DeliveryItem
import com.maruchin.ui.OrderProductItem
import com.maruchin.ui.PaymentItem
import com.maruchin.data.order.Order
import com.maruchin.data.order.sampleInProgressOrder
import com.maruchin.data.payments.Payment
import com.maruchin.features.order.R

@Composable
internal fun SummaryScreen(
    order: Order.InProgress?,
    onBackClick: () -> Unit,
    onProductClick: (productId: String) -> Unit,
    onSubmitOrderClick: () -> Unit,
    onCancelClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar(onBackClick = onBackClick, onCancelClick = onCancelClick)
        }
    ) { padding ->
        if (order == null) return@Scaffold

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            ProductsHeader()
            order.products.forEach { product ->
                OrderProductItem(
                    image = product.product.images.first(),
                    name = product.product.name,
                    price = product.product.price,
                    quantity = product.quantity,
                    onClick = { onProductClick(product.product.id) },
                )
            }
            DeliveryHeader()
            order.delivery?.let { delivery ->
                DeliveryItem(
                    logo = delivery.logo,
                    name = delivery.name,
                    price = delivery.price,
                    onClick = {}
                )
            }
            AddressHeader()
            order.address?.let { address ->
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
            PaymentHeader()
            order.payment?.let { payment ->
                PaymentSection(payment = payment, totalPrice = order.totalPrice)
            }
            SubmitOrderButton(onSubmitOrderClick)
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(onBackClick: () -> Unit, onCancelClick: () -> Unit) {
    Column {
        CenterAlignedTopAppBar(
            title = {
                Text(text = stringResource(R.string.summary))
            },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                TextButton(onClick = onCancelClick) {
                    Text(text = stringResource(R.string.cancel))
                }
            }
        )
        LinearProgressIndicator(progress = 1f, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
private fun ProductsHeader() {
    Text(
        text = stringResource(R.string.products),
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
private fun DeliveryHeader() {
    Text(
        text = stringResource(R.string.delivery),
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier
            .padding(16.dp)
            .padding(top = 32.dp)
    )
}

@Composable
private fun AddressHeader() {
    Text(
        text = stringResource(R.string.address),
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier
            .padding(16.dp)
            .padding(top = 32.dp)
    )
}

@Composable
private fun PaymentHeader() {
    Text(
        text = stringResource(R.string.payment),
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier
            .padding(16.dp)
            .padding(top = 32.dp)
    )
}

@Composable
private fun PaymentSection(payment: Payment, totalPrice: Double) {
    Row(
        modifier = Modifier.height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PaymentItem(
            logo = payment.logo,
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
        )
        Text(
            text = "$ $totalPrice",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier
                .padding(16.dp)
                .weight(2f),
            textAlign = TextAlign.End,
        )
    }
}

@Composable
private fun SubmitOrderButton(onSubmitOrderClick: () -> Unit) {
    Button(
        onClick = onSubmitOrderClick,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(text = stringResource(R.string.submit_order))
    }
}

@Preview
@Composable
private fun SummaryScreenPreview() {
    SummaryScreen(
        order = sampleInProgressOrder,
        onBackClick = {},
        onProductClick = {},
        onSubmitOrderClick = {},
        onCancelClick = {},
    )
}
