package com.maruchin.features.profile.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Stable
internal class ProfileTabsState(
    val pagerState: PagerState,
    private val scope: CoroutineScope,
) {

    val selectedTab: Int
        get() = pagerState.currentPage

    fun isSelected(tab: Int): Boolean {
        return pagerState.currentPage == tab
    }

    fun select(tab: Int) = scope.launch {
        pagerState.animateScrollToPage(tab)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun rememberProfileTabsState(numOfPages: Int): ProfileTabsState {
    val pagerState = rememberPagerState { numOfPages }
    val scope = rememberCoroutineScope()
    return remember(pagerState, scope) {
        ProfileTabsState(pagerState, scope)
    }
}