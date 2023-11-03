package com.maruchin.features.profile.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maruchin.features.profile.club.ClubPage

private const val FIRST = 0
private const val SECOND = 1
private const val THIRD = 2

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ProfileScreen(
    isLoggedIn: Boolean,
    onOpenSettings: () -> Unit,
    onOpenPurchaseHistory: () -> Unit,
    onOpenFindOutMore: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(onOpenSettings = onOpenSettings)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            val tabsState = rememberProfileTabsState(numOfPages = if (isLoggedIn) 3 else 2)

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
            HorizontalPager(state = tabsState.pagerState) { page ->
                when (page) {
                    FIRST -> ClubPage(
                        onOpenPurchaseHistory = onOpenPurchaseHistory,
                        onOpenFindOutMore = onOpenFindOutMore
                    )
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopAppBar(onOpenSettings: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Profile")
        },
        actions = {
            IconButton(onClick = onOpenSettings) {
                Icon(imageVector = Icons.Default.Settings, contentDescription = null)
            }
        }
    )
}

@Composable
private fun ClubTab(isSelected: Boolean, onClick: () -> Unit) {
    Tab(
        selected = isSelected,
        onClick = onClick,
        text = {
            Text(text = "Club")
        }
    )
}

@Composable
private fun PromotionsTab(isSelected: Boolean, onClick: () -> Unit) {
    Tab(
        selected = isSelected,
        onClick = onClick,
        text = {
            Text(text = "Promotions")
        }
    )
}

@Composable
private fun MyDataTab(isSelected: Boolean, onClick: () -> Unit) {
    Tab(
        selected = isSelected,
        onClick = onClick,
        text = {
            Text(text = "My data")
        }
    )
}

@Preview
@Composable
internal fun ProfileScreenPreview() {
    ProfileScreen(
        isLoggedIn = true,
        onOpenSettings = {},
        onOpenPurchaseHistory = {},
        onOpenFindOutMore = {}
    )
}
