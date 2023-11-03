package com.maruchin.features.profile.promotion

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.promotions.PromotionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class PromotionsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val promotionsRepository: PromotionsRepository,
) : ViewModel() {

    private val args = PromotionArgs(savedStateHandle)

    val promotion = promotionsRepository.getById(args.promotionId)
        .stateIn(viewModelScope, SharingStarted.Lazily, null)
}