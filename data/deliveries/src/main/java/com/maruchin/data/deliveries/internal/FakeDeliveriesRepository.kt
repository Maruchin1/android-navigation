package com.maruchin.data.deliveries.internal

import com.maruchin.data.deliveries.DeliveriesRepository
import com.maruchin.data.deliveries.Delivery
import com.maruchin.data.deliveries.DeliveryId
import com.maruchin.data.deliveries.sampleDeliveries
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FakeDeliveriesRepository @Inject constructor() : DeliveriesRepository {

    override fun getAll(): Flow<List<Delivery>> {
        return flowOf(sampleDeliveries)
    }

    override fun getById(deliveryId: DeliveryId): Flow<Delivery> {
        return flowOf(sampleDeliveries.first { it.id == deliveryId })
    }
}