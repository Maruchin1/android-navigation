package com.maruchin.data.promotions.internal

import com.maruchin.data.promotions.Promotion
import com.maruchin.data.promotions.PromotionsRepository
import com.maruchin.data.promotions.samplePromotions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FakePromotionsRepository @Inject constructor() : PromotionsRepository {

    private val promotions = MutableStateFlow(samplePromotions)

    override fun getAvailable(): Flow<List<Promotion>> {
        return promotions
    }

    override fun getById(id: String): Flow<Promotion> {
        return promotions.map { promotions ->
            promotions.first { it.id == id }
        }
    }
}