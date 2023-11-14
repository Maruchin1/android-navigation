package com.maruchin.data.deliveries

import androidx.annotation.DrawableRes

data class Delivery(
    val id: DeliveryId,
    @DrawableRes val logo: Int,
    val name: String,
    val price: Float,
)

@JvmInline
value class DeliveryId(val value: String)
