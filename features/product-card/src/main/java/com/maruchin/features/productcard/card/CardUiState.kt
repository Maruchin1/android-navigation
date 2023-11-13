package com.maruchin.features.productcard.card

import androidx.annotation.StringRes
import com.maruchin.data.products.Product

internal data class CardUiState(
    val product: Product? = null,
    @StringRes val message: Int? = null,
)
