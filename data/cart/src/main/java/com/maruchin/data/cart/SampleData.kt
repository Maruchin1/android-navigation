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

val sampleCartWithFixedPrice = Cart(
    products = listOf(
        CartProduct(
            product = sampleProducts[0].copy(price = 10.0),
            quantity = 1,
        ),
        CartProduct(
            product = sampleProducts[1].copy(price = 20.0),
            quantity = 2,
        ),
    )
)
