package com.maruchin.data.addresses.internal

import com.maruchin.data.addresses.Address
import com.maruchin.data.addresses.AddressId
import com.maruchin.data.addresses.AddressesRepository
import com.maruchin.data.addresses.sampleAddress
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FakeAddressesRepository @Inject constructor() : AddressesRepository {

    private val addresses = MutableStateFlow(listOf(sampleAddress))

    override fun getAll(): Flow<List<Address>> {
        return addresses
    }

    override fun getById(id: AddressId): Flow<Address?> {
        return addresses.map { list ->
            list.find { it.id == id }
        }
    }

    override suspend fun save(address: Address) {
        val existingAddress = addresses.value.find { it.id == address.id }
        if (existingAddress == null) {
            addresses.update {
                it + address
            }
        } else {
            addresses.update { list ->
                list.map { if (it.id == address.id) address else it }
            }
        }
    }
}