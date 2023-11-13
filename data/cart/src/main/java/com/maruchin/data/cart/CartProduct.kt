package com.maruchin.data.cart

import com.maruchin.data.products.Product

data class CartProduct(
    val product: Product,
    val quantity: Int,
)
