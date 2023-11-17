package com.maruchin.features.mydata.myaddresses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.addresses.AddressesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class MyAddressesViewModel @Inject constructor(
    private val addressesRepository: AddressesRepository
) : ViewModel() {

    val uiState = addressesRepository.getAll()
        .map(::MyAddressesUiState)
        .stateIn(viewModelScope, SharingStarted.Lazily, MyAddressesUiState())
}