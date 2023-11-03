package com.maruchin.data.promotions

import kotlinx.coroutines.flow.Flow

interface PromotionsRepository {

    fun getAvailablePromotions(): Flow<List<Promotion>>
}