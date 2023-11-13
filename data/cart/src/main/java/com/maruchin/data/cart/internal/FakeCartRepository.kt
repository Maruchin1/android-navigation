package com.maruchin.data.cart.internal

import com.maruchin.data.cart.Cart
import com.maruchin.data.cart.CartProduct
import com.maruchin.data.cart.CartRepository
import com.maruchin.data.cart.sampleCart
import com.maruchin.data.products.Product
import com.maruchin.data.products.ProductId
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FakeCartRepository @Inject constructor() : CartRepository {

    private val cart = MutableStateFlow(sampleCart)
    override fun get(): Flow<Cart> {
        return cart
    }

    override suspend fun addProduct(product: Product) {
        val cartProduct = CartProduct(product = product, quantity = 1)
        cart.update { cart ->
            cart.copy(products = cart.products + cartProduct)
        }
    }

    override suspend fun removeProduct(productId: ProductId) {
        cart.update { cart ->
            cart.copy(products = cart.products.filter { it.product.id != productId })
        }
    }

    override suspend fun increaseProductQuantity(productId: ProductId) {
        cart.update { cart ->
            cart.copy(
                products = cart.products.map { cartProduct ->
                    if (cartProduct.product.id == productId) {
                        cartProduct.copy(quantity = cartProduct.quantity + 1)
                    } else {
                        cartProduct
                    }
                }
            )
        }
    }

    override suspend fun decreaseProductQuantity(productId: ProductId) {
        cart.update { cart ->
            cart.copy(
                products = cart.products.map { cartProduct ->
                    if (cartProduct.product.id == productId) {
                        cartProduct.copy(quantity = cartProduct.quantity - 1)
                    } else {
                        cartProduct
                    }
                }
            )
        }
    }
}