package com.maruchin.features.order.summary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.order.Order
import com.maruchin.data.order.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SummaryViewModel @Inject constructor(
    private val orderRepository: OrderRepository,
) : ViewModel() {

    val order = orderRepository.get()
        .filterIsInstance<Order.InProgress>()
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    val isSubmitted = orderRepository.get()
        .map { it is Order.Submitted }
        .stateIn(viewModelScope, SharingStarted.Lazily, false)

    fun submit() = viewModelScope.launch {
        orderRepository.submit()
    }
}