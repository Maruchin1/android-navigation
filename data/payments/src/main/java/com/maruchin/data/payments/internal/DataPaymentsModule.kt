package com.maruchin.data.payments.internal

import com.maruchin.data.payments.PaymentsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataPaymentsModule {

    @Binds
    fun bindPaymentsRepository(impl: FakePaymentsRepository): PaymentsRepository
}