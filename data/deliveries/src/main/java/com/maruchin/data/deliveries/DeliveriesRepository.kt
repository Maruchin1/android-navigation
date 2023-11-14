package com.maruchin.data.deliveries

import kotlinx.coroutines.flow.Flow

interface DeliveriesRepository {

    fun getAll(): Flow<List<Delivery>>

    fun getById(deliveryId: DeliveryId): Flow<Delivery>
}