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
import androidx.compose.ui.tooling.preview.Preview
import com.maruchin.core.ui.DeliveryItem
import com.maruchin.data.deliveries.sampleDeliveries

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DeliveryScreen(
    state: DeliveryUiState,
    onBackClick: () -> Unit,
    onCancelClick: () -> Unit,
    onSelectDelivery: (deliveryId: String) -> Unit
) {
    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Choose delivery")
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
                LinearProgressIndicator(progress = 0.25f, modifier = Modifier.fillMaxWidth())
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            state.deliveries.forEach { delivery ->
                DeliveryItem(
                    logo = delivery.logo,
                    name = delivery.name,
                    price = delivery.price,
                    onClick = { onSelectDelivery(delivery.id) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun DeliveryScreenPreview() {
    DeliveryScreen(
        state = DeliveryUiState(
            deliveries = sampleDeliveries
        ),
        onBackClick = {},
        onCancelClick = {},
        onSelectDelivery = {},
    )
}