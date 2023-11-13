package com.maruchin.data.cart

data class Cart(
    val products: List<CartProduct> = emptyList()
) {

    val totalPrice: Float
        get() = products.sumOf { it.product.price.toDouble() }.toFloat()
}