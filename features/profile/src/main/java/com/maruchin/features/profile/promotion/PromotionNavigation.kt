package com.maruchin.features.profile.promotion

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.data.promotions.PromotionId

private const val PROMOTION_ID = "promotionId"
internal const val PROMOTION_ROUTE = "promotion/{$PROMOTION_ID}"

internal data class PromotionArgs(val promotionId: PromotionId) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        promotionId = PromotionId(savedStateHandle[PROMOTION_ID]!!)
    )
}

internal fun NavGraphBuilder.promotionScreen(onBack: () -> Unit) {
    composable(PROMOTION_ROUTE) {
        val viewModel: PromotionsViewModel = hiltViewModel()
        val promotion by viewModel.promotion.collectAsState()

        if (promotion == null) return@composable

        PromotionScreen(promotion = promotion!!, onBack = onBack)
    }
}

internal fun NavController.navigateToPromotion(promotionId: PromotionId) {
    navigate(PROMOTION_ROUTE.replace("{$PROMOTION_ID}", promotionId.value))
}
