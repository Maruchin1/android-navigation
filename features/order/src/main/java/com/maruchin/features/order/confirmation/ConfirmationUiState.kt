package com.maruchin.features.order.confirmation

import androidx.compose.runtime.Immutable
import com.maruchin.data.order.Order

@Immutable
internal data class ConfirmationUiState(
    val order: Order.Submitted? = null,
)
