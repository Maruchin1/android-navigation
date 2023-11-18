package com.maruchin.features.order.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.order.OrderRepository
import com.maruchin.data.payments.Payment
import com.maruchin.data.payments.PaymentsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class PaymentViewModel @Inject constructor(
    private val paymentsRepository: PaymentsRepository,
    private val orderRepository: OrderRepository,
) : ViewModel() {

    val payments = paymentsRepository.getAll()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun selectPayment(payment: Payment) = viewModelScope.launch {
        orderRepository.selectPayment(payment)
    }
}