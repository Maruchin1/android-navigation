package com.maruchin.features.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.cart.CartRepository
import com.maruchin.data.order.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository,
    private val orderRepository: OrderRepository,
) : ViewModel() {

    val cart = cartRepository.get()
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    fun createNewOrder() = viewModelScope.launch {
        val cart = cartRepository.get().first()
        orderRepository.createNew(cart.products)
    }
}