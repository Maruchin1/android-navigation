package com.maruchin.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.domain.products.GroupRecommendedProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val groupRecommendedProductsUseCase: GroupRecommendedProductsUseCase,
) : ViewModel() {

    val products = groupRecommendedProductsUseCase()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyMap())
}