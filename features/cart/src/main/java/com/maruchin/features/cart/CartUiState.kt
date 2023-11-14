package com.maruchin.features.cart

import com.maruchin.data.cart.Cart
import com.maruchin.data.cart.CartProduct
import com.maruchin.data.products.ProductId

internal data class CartUiState(
    val products: List<CartProductUiState> = emptyList(),
    val totalPrice: Double = 0.0,
)

internal data class CartProductUiState(
    val id: ProductId,
    val image: Int,
    val name: String,
    val price: Double,
    val quantity: Int,
)

internal fun createCartUiState(cart: Cart) = CartUiState(
    products = cart.products.map(::createCartProductUiState),
    totalPrice = cart.totalPrice.toDouble(),
)

internal fun createCartProductUiState(cartProduct: CartProduct) = CartProductUiState(
    id = cartProduct.product.id,
    image = cartProduct.product.images.first(),
    name = cartProduct.product.name,
    price = cartProduct.product.price.toDouble(),
    quantity = cartProduct.quantity,
)
