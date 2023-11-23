package com.maruchin.features.profile.promotion

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.maruchin.ui.ROOT_DEEPLINK

private const val PROMOTION_ID = "promotionId"
internal const val PROMOTION_ROUTE = "promotion/{$PROMOTION_ID}"
private const val PROMOTION_DEEPLINK = "$ROOT_DEEPLINK/promotion/{$PROMOTION_ID}"

internal data class PromotionArgs(val promotionId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        promotionId = checkNotNull(savedStateHandle[PROMOTION_ID])
    )
}

internal fun NavController.navigateToPromotion(promotionId: String) {
    navigate(PROMOTION_ROUTE.replace("{$PROMOTION_ID}", promotionId))
}

internal fun NavGraphBuilder.promotionScreen(onBackClick: () -> Unit) {
    composable(
        route = PROMOTION_ROUTE,
        deepLinks = listOf(
            navDeepLink { uriPattern = PROMOTION_DEEPLINK }
        )
    ) {
        val viewModel: PromotionsViewModel = hiltViewModel()
        val promotion by viewModel.promotion.collectAsState()

        PromotionScreen(promotion = promotion, onBackClick = onBackClick)
    }
}
