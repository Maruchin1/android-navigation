package com.maruchin.data.order

import com.maruchin.data.addresses.sampleAddress
import com.maruchin.data.deliveries.sampleDeliveries
import com.maruchin.data.payments.samplePayments
import com.maruchin.data.products.sampleProducts

val sampleInProgressOrder = Order.InProgress(
    products = listOf(
        OrderProduct(product = sampleProducts[0], quantity = 1),
        OrderProduct(product = sampleProducts[1], quantity = 2),
    ),
    delivery = sampleDeliveries[0],
    address = sampleAddress,
    payment = samplePayments[0],
)

val sampleSubmittedOrder = Order.Submitted(orderNumber = "1234567890")
