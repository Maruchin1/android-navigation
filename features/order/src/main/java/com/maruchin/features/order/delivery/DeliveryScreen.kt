package com.maruchin.features.order.delivery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maruchin.ui.DeliveryItem
import com.maruchin.data.deliveries.Delivery
import com.maruchin.data.deliveries.sampleDeliveries
import com.maruchin.features.order.R

@Composable
internal fun DeliveryScreen(
    deliveries: List<Delivery>,
    onBackClick: () -> Unit,
    onCancelClick: () -> Unit,
    onDeliveryClick: (delivery: Delivery) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(onBackClick = onBackClick, onCancelClick = onCancelClick)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            deliveries.forEach { delivery ->
                DeliveryItem(
                    logo = delivery.logo,
                    name = delivery.name,
                    price = delivery.price,
                    onClick = { onDeliveryClick(delivery) }
                )
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(onBackClick: () -> Unit, onCancelClick: () -> Unit) {
    Column {
        CenterAlignedTopAppBar(
            title = {
                Text(text = stringResource(R.string.choose_delivery))
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
        LinearProgressIndicator(progress = 0.25f, modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
private fun DeliveryScreenPreview() {
    DeliveryScreen(
        deliveries = sampleDeliveries,
        onBackClick = {},
        onCancelClick = {},
        onDeliveryClick = {},
    )
}