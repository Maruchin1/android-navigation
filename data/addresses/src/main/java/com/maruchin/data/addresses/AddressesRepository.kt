package com.maruchin.data.addresses

import kotlinx.coroutines.flow.Flow

interface AddressesRepository {

    fun getAll(): Flow<List<Address>>

    fun getById(id: String): Flow<Address?>

    suspend fun save(address: Address)
}