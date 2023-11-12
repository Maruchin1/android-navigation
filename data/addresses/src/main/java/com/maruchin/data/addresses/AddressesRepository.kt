package com.maruchin.data.addresses

import kotlinx.coroutines.flow.Flow

interface AddressesRepository {

    fun getAll(): Flow<List<Address>>

    fun getById(id: AddressId): Flow<Address?>

    suspend fun save(address: Address)
}