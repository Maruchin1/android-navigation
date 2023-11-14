package com.maruchin.data.deliveries.internal

import com.maruchin.data.deliveries.DeliveriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataDeliveriesModule {

    @Binds
    fun bindDeliveriesRepository(impl: FakeDeliveriesRepository): DeliveriesRepository
}