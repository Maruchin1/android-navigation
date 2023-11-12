package com.maruchin.features.profile.findoutmore

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
internal class FindOutMorePagerState(
    val pagerState: PagerState,
    private val scope: CoroutineScope
) {

    val currentPage: Int
        get() = pagerState.currentPage

    fun isSelectedPage(page: Int) = currentPage == page

    fun selectPage(page: Int) = scope.launch {
        pagerState.animateScrollToPage(page)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun rememberFindOutPagerState(): FindOutMorePagerState {
    val pagerState = rememberPagerState { 3 }
    val scope = rememberCoroutineScope()
    return remember(pagerState, scope) {
        FindOutMorePagerState(pagerState, scope)
    }
}
