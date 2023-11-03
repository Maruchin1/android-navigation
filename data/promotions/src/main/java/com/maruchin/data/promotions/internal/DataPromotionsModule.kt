package com.maruchin.data.promotions.internal

import com.maruchin.data.promotions.PromotionsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataPromotionsModule {

    @Binds
    fun bindPromotionsRepository(fake: FakePromotionsRepository): PromotionsRepository
}