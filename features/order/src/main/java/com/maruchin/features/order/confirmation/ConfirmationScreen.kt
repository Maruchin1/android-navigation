package com.maruchin.features.order.confirmation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.data.order.Order
import com.maruchin.data.order.sampleSubmittedOrder
import com.maruchin.features.order.R

@Composable
internal fun ConfirmationScreen(order: Order.Submitted?, onCloseClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopBar(onCloseClick)
        }
    ) { padding ->
        if (order == null) return@Scaffold

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            ConfirmationIcon()
            Spacer(modifier = Modifier.height(32.dp))
            ConfirmationText()
            Spacer(modifier = Modifier.height(32.dp))
            OrderNumberLabel()
            Spacer(modifier = Modifier.height(16.dp))
            OrderNumberText(text = order.orderNumber)
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(onCloseClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.your_order))
        },
        navigationIcon = {
            IconButton(onClick = onCloseClick) {
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }
        }
    )
}

@Composable
private fun ConfirmationIcon() {
    Icon(
        imageVector = Icons.Default.CheckCircleOutline,
        contentDescription = null,
        modifier = Modifier.size(128.dp),
        tint = MaterialTheme.colorScheme.primary,
    )
}

@Composable
private fun ConfirmationText() {
    Text(
        text = stringResource(R.string.we_received_your_order),
        style = MaterialTheme.typography.headlineMedium
    )
}

@Composable
private fun OrderNumberLabel() {
    Text(
        text = stringResource(R.string.order_number),
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
private fun OrderNumberText(text: String) {
    Text(text = text, style = MaterialTheme.typography.titleLarge)
}

@Preview
@Composable
private fun ConfirmationScreenPreview() {
    ConfirmationScreen(
        order = sampleSubmittedOrder,
        onCloseClick = {},
    )
}
