package com.maruchin.features.order.confirmation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.order.Order
import com.maruchin.data.order.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class ConfirmationViewModel @Inject constructor(
    private val orderRepository: OrderRepository,
) : ViewModel() {

    val order = orderRepository.get()
        .filterIsInstance<Order.Submitted>()
        .stateIn(viewModelScope, SharingStarted.Lazily, null)
}