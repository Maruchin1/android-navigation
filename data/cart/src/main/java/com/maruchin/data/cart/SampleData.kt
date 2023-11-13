package com.maruchin.data.cart

import com.maruchin.data.products.sampleProducts

val sampleCart = Cart(
    products = listOf(
        CartProduct(
            product = sampleProducts[0],
            quantity = 1,
        ),
        CartProduct(
            product = sampleProducts[1],
            quantity = 2,
        ),
    )
)