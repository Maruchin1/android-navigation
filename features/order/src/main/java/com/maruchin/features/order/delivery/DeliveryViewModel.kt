package com.maruchin.features.order.delivery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.deliveries.DeliveriesRepository
import com.maruchin.data.order.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DeliveryViewModel @Inject constructor(
    private val deliveriesRepository: DeliveriesRepository,
    private val orderRepository: OrderRepository,
) : ViewModel() {

    val uiState = deliveriesRepository.getAll()
        .map(::DeliveryUiState)
        .stateIn(viewModelScope, SharingStarted.Lazily, DeliveryUiState())

    fun selectDelivery(deliveryId: String) = viewModelScope.launch {
        val delivery = deliveriesRepository.getById(deliveryId).first()
        orderRepository.selectDelivery(delivery)
    }
}