package com.maruchin.data.promotions

import kotlinx.coroutines.flow.Flow

interface PromotionsRepository {

    fun getAvailable(): Flow<List<Promotion>>

    fun getById(id: PromotionId): Flow<Promotion>
}