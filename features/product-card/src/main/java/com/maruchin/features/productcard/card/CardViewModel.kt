package com.maruchin.features.productcard.card

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.products.ProductsRepository
import com.maruchin.features.productcard.ProductCardArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class CardViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val productsRepository: ProductsRepository,
) : ViewModel() {

    private val args = ProductCardArgs(savedStateHandle)

    val product = flow { emit(productsRepository.getById(args.productId)) }
        .stateIn(viewModelScope, SharingStarted.Lazily, null)
}