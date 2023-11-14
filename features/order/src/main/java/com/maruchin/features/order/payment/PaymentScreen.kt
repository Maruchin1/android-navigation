package com.maruchin.features.order.payment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.unit.dp
import com.maruchin.core.ui.PaymentItem
import com.maruchin.data.payments.Payment
import com.maruchin.data.payments.samplePayments

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PaymentScreen(
    state: PaymentUiState,
    onBackClick: () -> Unit,
    onCancelClick: () -> Unit,
    onPaymentClick: (Payment) -> Unit,
) {
    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Payment")
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
                LinearProgressIndicator(progress = 0.75f, modifier = Modifier.fillMaxWidth())
            }
        }
    ) { padding ->
        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(padding)) {
            items(state.payments) { payment ->
                PaymentItem(
                    logo = payment.logo,
                    modifier = Modifier.padding(16.dp),
                    onClick = { onPaymentClick(payment) },
                )
            }
        }
    }
}

@Preview
@Composable
private fun PaymentScreenPreview() {
    PaymentScreen(
        state = PaymentUiState(payments = samplePayments),
        onBackClick = {},
        onPaymentClick = {},
        onCancelClick = {},
    )
}
