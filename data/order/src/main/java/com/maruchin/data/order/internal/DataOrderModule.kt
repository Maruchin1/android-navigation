package com.maruchin.data.order.internal

import com.maruchin.data.order.OrderRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataOrderModule {

    @Binds
    fun bindOrderRepository(impl: FakeOrderRepository): OrderRepository
}