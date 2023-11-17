package com.maruchin.data.cart

import com.maruchin.data.products.Product
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    fun get(): Flow<Cart>

    suspend fun addProduct(product: Product)

    suspend fun removeProduct(productId: String)

    suspend fun increaseProductQuantity(productId: String)

    suspend fun decreaseProductQuantity(productId: String)
}