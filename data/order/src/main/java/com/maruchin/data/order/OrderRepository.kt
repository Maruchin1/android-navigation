package com.maruchin.data.order

import com.maruchin.data.addresses.Address
import com.maruchin.data.cart.CartProduct
import com.maruchin.data.deliveries.Delivery
import com.maruchin.data.payments.Payment
import kotlinx.coroutines.flow.Flow

interface OrderRepository {

    fun get(): Flow<Order>

    suspend fun createNew(products: List<CartProduct>)

    suspend fun selectDelivery(delivery: Delivery)

    suspend fun selectAddress(address: Address)

    suspend fun selectPayment(payment: Payment)

    suspend fun submit()
}