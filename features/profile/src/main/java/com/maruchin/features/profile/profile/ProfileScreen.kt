package com.maruchin.features.profile.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maruchin.features.profile.R
import com.maruchin.features.profile.club.ClubPage
import com.maruchin.features.profile.clubauth.ClubAuthPage
import com.maruchin.features.profile.mydata.MyDataPage
import com.maruchin.features.profile.promotions.PromotionsPage

private const val FIRST = 0
private const val SECOND = 1
private const val THIRD = 2

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ProfileScreen(
    isLoggedIn: Boolean,
    onPurchaseHistoryClick: () -> Unit,
    onFindOutMoreClick: () -> Unit,
    onPromotionClick: (promotionId: String) -> Unit,
    onMyDataClick: () -> Unit,
    onMyOrdersClick: () -> Unit,
    onReturnsClick: () -> Unit,
    onLoginClick: () -> Unit,
    onJoinClubClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            val tabsState = rememberProfileTabsState(numOfPages = if (isLoggedIn) 3 else 2)

            ProfileTabs(tabsState, isLoggedIn)
            ProfilePager(
                pagerState = tabsState.pagerState,
                isLoggedIn = isLoggedIn,
                onPurchaseHistoryClick = onPurchaseHistoryClick,
                onFindOutMoreClick = onFindOutMoreClick,
                onLoginClick = onLoginClick,
                onJoinClubClick = onJoinClubClick,
                onPromotionClick = onPromotionClick,
                onMyDataClick = onMyDataClick,
                onMyOrdersClick = onMyOrdersClick,
                onReturnsClick = onReturnsClick,
            )
        }
    }
}

@Composable
private fun ProfileTabs(
    tabsState: ProfileTabsState,
    isLoggedIn: Boolean
) {
    TabRow(selectedTabIndex = tabsState.selectedTab) {
        ClubTab(
            isSelected = tabsState.isSelected(FIRST),
            onClick = { tabsState.select(FIRST) }
        )
        PromotionsTab(
            isSelected = tabsState.isSelected(SECOND),
            onClick = { tabsState.select(SECOND) }
        )
        if (isLoggedIn) {
            MyDataTab(
                isSelected = tabsState.isSelected(THIRD),
                onClick = { tabsState.select(THIRD) }
            )
        }
    }
}

@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun ProfilePager(
    pagerState: PagerState,
    isLoggedIn: Boolean,
    onPurchaseHistoryClick: () -> Unit,
    onFindOutMoreClick: () -> Unit,
    onLoginClick: () -> Unit,
    onJoinClubClick: () -> Unit,
    onPromotionClick: (promotionId: String) -> Unit,
    onMyDataClick: () -> Unit,
    onMyOrdersClick: () -> Unit,
    onReturnsClick: () -> Unit
) {
    HorizontalPager(state = pagerState) { page ->
        when (page) {
            FIRST -> if (isLoggedIn) {
                ClubPage(
                    onPurchaseHistoryClick = onPurchaseHistoryClick,
                    onFindOutMoreClick = onFindOutMoreClick
                )
            } else {
                ClubAuthPage(
                    onLearnMoreClick = onFindOutMoreClick,
                    onLoginClick = onLoginClick,
                    onJoinClubClick = onJoinClubClick,
                )
            }

            SECOND -> PromotionsPage(
                onPromotionClick = onPromotionClick
            )

            THIRD -> MyDataPage(
                onMyDataClick = onMyDataClick,
                onMyOrdersClick = onMyOrdersClick,
                onReturnsClick = onReturnsClick,
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.profile))
        },
    )
}

@Composable
private fun ClubTab(isSelected: Boolean, onClick: () -> Unit) {
    Tab(
        selected = isSelected,
        onClick = onClick,
        text = {
            Text(text = stringResource(R.string.club))
        }
    )
}

@Composable
private fun PromotionsTab(isSelected: Boolean, onClick: () -> Unit) {
    Tab(
        selected = isSelected,
        onClick = onClick,
        text = {
            Text(text = stringResource(R.string.promotions))
        }
    )
}

@Composable
private fun MyDataTab(isSelected: Boolean, onClick: () -> Unit) {
    Tab(
        selected = isSelected,
        onClick = onClick,
        text = {
            Text(text = stringResource(R.string.my_data))
        }
    )
}

@Preview
@Composable
internal fun ProfileScreenPreview() {
    ProfileScreen(
        isLoggedIn = true,
        onPurchaseHistoryClick = {},
        onFindOutMoreClick = {},
        onPromotionClick = {},
        onMyDataClick = {},
        onMyOrdersClick = {},
        onReturnsClick = {},
        onLoginClick = {},
        onJoinClubClick = {},
    )
}
