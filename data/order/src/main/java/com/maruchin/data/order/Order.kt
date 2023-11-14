package com.maruchin.data.order

import com.maruchin.data.addresses.Address
import com.maruchin.data.deliveries.Delivery
import com.maruchin.data.payments.Payment

sealed interface Order {

    object None : Order

    data class InProgress(
        val products: List<OrderProduct>,
        val delivery: Delivery? = null,
        val address: Address? = null,
        val payment: Payment? = null,
    ) : Order

    data class Submitted(val orderNumber: String) : Order
}

fun Order.InProgress.calculateTotalPrice(): Float {
    val productsPrice = products.sumOf { it.product.price.toDouble() * it.quantity }
    val deliveryPrice = delivery?.price ?: 0f
    return (productsPrice + deliveryPrice).toFloat()
}
