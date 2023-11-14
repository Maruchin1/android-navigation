package com.maruchin.data.payments

import kotlinx.coroutines.flow.Flow

interface PaymentsRepository {

    fun getAll(): Flow<List<Payment>>
}