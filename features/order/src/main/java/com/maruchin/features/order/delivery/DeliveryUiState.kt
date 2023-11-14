package com.maruchin.features.order.delivery

import androidx.compose.runtime.Immutable
import com.maruchin.data.deliveries.Delivery

@Immutable
internal data class DeliveryUiState(
    val deliveries: List<Delivery> = emptyList()
)