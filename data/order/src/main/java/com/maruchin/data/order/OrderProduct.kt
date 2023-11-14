package com.maruchin.data.order

import com.maruchin.data.products.Product

data class OrderProduct(
    val product: Product,
    val quantity: Int,
)