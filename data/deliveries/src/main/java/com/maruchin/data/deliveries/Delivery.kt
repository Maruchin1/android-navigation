package com.maruchin.data.deliveries

import androidx.annotation.DrawableRes

data class Delivery(
    val id: String,
    @DrawableRes
    val logo: Int,
    val name: String,
    val price: Float,
)
