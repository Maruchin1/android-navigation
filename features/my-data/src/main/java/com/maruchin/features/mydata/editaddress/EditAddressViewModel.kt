package com.maruchin.features.mydata.editaddress

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.addresses.Address
import com.maruchin.data.addresses.AddressesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class EditAddressViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val addressesRepository: AddressesRepository,
) : ViewModel() {

    private val args = EditAddressArgs(savedStateHandle)

    val address = addressesRepository.getById(args.addressId)
        .take(1)
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    var isSaved: Boolean by mutableStateOf(false)
        private set

    fun saveAddress(address: Address) = viewModelScope.launch {
        val updatedAddress = address.copy(id = args.addressId)
        addressesRepository.save(updatedAddress)
        isSaved = true
    }
}