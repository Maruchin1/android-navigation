package com.maruchin.data.addresses.internal

import com.maruchin.data.addresses.AddressesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataAddressesModule {

    @Binds
    fun bindAddressesRepository(impl: FakeAddressesRepository): AddressesRepository
}