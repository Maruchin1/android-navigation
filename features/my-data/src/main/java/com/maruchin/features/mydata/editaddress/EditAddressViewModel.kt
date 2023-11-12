package com.maruchin.features.mydata.editaddress

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.addresses.Address
import com.maruchin.data.addresses.AddressesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class EditAddressViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val addressesRepository: AddressesRepository,
) : ViewModel() {

    private val args = EditAddressArgs(savedStateHandle)
    private val _uiState = MutableStateFlow(EditAddressUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadAddress()
    }

    fun saveAddress(
        firstName: String,
        lastName: String,
        street: String,
        house: String,
        apartment: String,
        postalCode: String,
        city: String,
    ) = viewModelScope.launch {
        val address = Address(
            id = args.addressId,
            firstName = firstName,
            lastName = lastName,
            street = street,
            house = house,
            apartment = apartment,
            postalCode = postalCode,
            city = city,
        )
        addressesRepository.save(address)
        _uiState.update {
            it.copy(isSaved = true)
        }
    }

    private fun loadAddress() = viewModelScope.launch {
        val address = addressesRepository.getById(args.addressId).first() ?: return@launch
        _uiState.value = EditAddressUiState(address)
    }
}