package com.maruchin.features.profile.promotion

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val PROMOTION_ID = "promotionId"
internal const val PROMOTION_ROUTE = "promotion/{$PROMOTION_ID}"

internal data class PromotionArgs(val promotionId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        promotionId = checkNotNull(savedStateHandle[PROMOTION_ID])
    )
}

internal fun NavController.navigateToPromotion(promotionId: String) {
    navigate(PROMOTION_ROUTE.replace("{$PROMOTION_ID}", promotionId))
}

internal fun NavGraphBuilder.promotionScreen(onBackClick: () -> Unit) {
    composable(PROMOTION_ROUTE) {
        val viewModel: PromotionsViewModel = hiltViewModel()
        val promotion by viewModel.promotion.collectAsState()

        PromotionScreen(promotion = promotion, onBackClick = onBackClick)
    }
}
