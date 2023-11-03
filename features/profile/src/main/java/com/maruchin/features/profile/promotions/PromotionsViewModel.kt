package com.maruchin.features.profile.promotions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.promotions.PromotionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class PromotionsViewModel @Inject constructor(
    private val promotionsRepository: PromotionsRepository,
) : ViewModel() {

    val promotions = promotionsRepository.getAvailable()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}