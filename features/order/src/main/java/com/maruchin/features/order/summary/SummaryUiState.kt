package com.maruchin.features.order.summary

import com.maruchin.data.order.Order

internal data class SummaryUiState(
    val order: Order = Order.None,
)
