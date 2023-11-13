package com.maruchin.data.cart.internal

import com.maruchin.data.cart.CartRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataCartModule {

    @Binds
    fun bindCartRepository(impl: FakeCartRepository): CartRepository
}