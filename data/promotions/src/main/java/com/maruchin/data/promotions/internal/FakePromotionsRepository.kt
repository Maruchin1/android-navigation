package com.maruchin.data.promotions.internal

import com.maruchin.data.promotions.Promotion
import com.maruchin.data.promotions.PromotionsRepository
import com.maruchin.data.promotions.samplePromotions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

@Singleton
internal class FakePromotionsRepository : PromotionsRepository {

    private val promotions = MutableStateFlow(samplePromotions)

    override fun getAvailablePromotions(): Flow<List<Promotion>> {
        return promotions
    }
}