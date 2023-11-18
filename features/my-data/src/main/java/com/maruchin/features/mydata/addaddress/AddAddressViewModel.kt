package com.maruchin.features.mydata.addaddress

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.addresses.Address
import com.maruchin.data.addresses.AddressesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class AddAddressViewModel @Inject constructor(
    private val addressesRepository: AddressesRepository,
) : ViewModel() {

    var isSaved by mutableStateOf(false)
        private set

    fun submitAddAddress(address: Address) = viewModelScope.launch {
        addressesRepository.save(address)
        isSaved = true
    }
}