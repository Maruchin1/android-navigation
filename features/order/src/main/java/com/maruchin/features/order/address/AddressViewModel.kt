package com.maruchin.features.order.address

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.addresses.Address
import com.maruchin.data.order.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class AddressViewModel @Inject constructor(
    private val orderRepository: OrderRepository,
) : ViewModel() {

    fun selectAddress(address: Address) = viewModelScope.launch {
        orderRepository.selectAddress(address)
    }
}