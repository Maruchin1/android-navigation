package com.maruchin.features.mydata.addaddress

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.addresses.Address
import com.maruchin.data.addresses.AddressesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
internal class AddAddressViewModel @Inject constructor(
    private val addressesRepository: AddressesRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddAddressUiState())
    val uiState = _uiState.asStateFlow()

    fun submitAddAddress(
        firstName: String,
        lastName: String,
        street: String,
        house: String,
        apartment: String,
        postalCode: String,
        city: String
    ) = viewModelScope.launch {
        val address = Address(
            id = Random.nextInt().toString(),
            firstName = firstName,
            lastName = lastName,
            street = street,
            house = house,
            apartment = apartment.takeIf { it.isNotBlank() },
            postalCode = postalCode,
            city = city,
        )
        addressesRepository.save(address)
        _uiState.update {
            it.copy(isSaved = true)
        }
    }
}