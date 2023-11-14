package com.maruchin.data.payments.internal

import com.maruchin.data.payments.Payment
import com.maruchin.data.payments.PaymentsRepository
import com.maruchin.data.payments.samplePayments
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FakePaymentsRepository @Inject constructor() : PaymentsRepository {

    override fun getAll(): Flow<List<Payment>> {
        return flowOf(samplePayments)
    }
}