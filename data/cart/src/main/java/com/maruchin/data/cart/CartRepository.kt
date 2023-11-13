package com.maruchin.data.cart

import com.maruchin.data.products.Product
import com.maruchin.data.products.ProductId
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    fun get(): Flow<Cart>

    suspend fun addProduct(product: Product)

    suspend fun removeProduct(productId: ProductId)

    suspend fun increaseProductQuantity(productId: ProductId)

    suspend fun decreaseProductQuantity(productId: ProductId)
}