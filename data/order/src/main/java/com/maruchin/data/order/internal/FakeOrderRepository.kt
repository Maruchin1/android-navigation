package com.maruchin.data.order.internal

import com.maruchin.data.addresses.Address
import com.maruchin.data.cart.CartProduct
import com.maruchin.data.deliveries.Delivery
import com.maruchin.data.order.Order
import com.maruchin.data.order.OrderProduct
import com.maruchin.data.order.OrderRepository
import com.maruchin.data.payments.Payment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FakeOrderRepository @Inject constructor() : OrderRepository {

    private val order = MutableStateFlow<Order>(Order.None)

    override fun get(): Flow<Order> {
        return order
    }

    override suspend fun createNew(products: List<CartProduct>) {
        val orderProducts = products.map {
            OrderProduct(product = it.product, quantity = it.quantity)
        }
        order.value = Order.InProgress(products = orderProducts)
    }

    override suspend fun selectDelivery(delivery: Delivery) {
        val inProgressOrder = order.value as? Order.InProgress ?: return
        order.value = inProgressOrder.copy(delivery = delivery)
    }

    override suspend fun selectAddress(address: Address) {
        val inProgressOrder = order.value as? Order.InProgress ?: return
        order.value = inProgressOrder.copy(address = address)
    }

    override suspend fun selectPayment(payment: Payment) {
        val inProgressOrder = order.value as? Order.InProgress ?: return
        order.value = inProgressOrder.copy(payment = payment)
    }

    override suspend fun submit() {
        order.value = Order.Submitted(orderNumber = "123456789")
    }
}