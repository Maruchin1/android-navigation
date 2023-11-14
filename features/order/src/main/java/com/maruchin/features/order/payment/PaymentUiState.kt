package com.maruchin.features.order.payment

import androidx.compose.runtime.Immutable
import com.maruchin.data.payments.Payment

@Immutable
internal data class PaymentUiState(
    val payments: List<Payment> = emptyList()
)
