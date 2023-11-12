package com.maruchin.features.profile.findoutmore

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private const val STANDARD = 0
private const val SILVER = 1
private const val GOLD = 2

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
internal fun FindOutMoreScreen(onClose: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Find out more")
                },
                actions = {
                    IconButton(onClick = onClose) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 40.dp, vertical = 16.dp)
            )

            val pagerState = rememberFindOutPagerState()

            TabRow(selectedTabIndex = pagerState.currentPage) {
                Tab(
                    selected = pagerState.isSelectedPage(STANDARD),
                    onClick = { pagerState.selectPage(STANDARD) },
                    text = { Text(text = "Standard") },
                )
                Tab(
                    selected = pagerState.isSelectedPage(SILVER),
                    onClick = { pagerState.selectPage(SILVER) },
                    text = { Text(text = "Silver") },
                )
                Tab(
                    selected = pagerState.isSelectedPage(GOLD),
                    onClick = { pagerState.selectPage(GOLD) },
                    text = { Text(text = "Gold") },
                )
            }
            HorizontalPager(pagerState.pagerState) { page ->
                when (page) {
                    STANDARD -> BenefitsList(numOfBenefits = 4)
                    SILVER -> BenefitsList(numOfBenefits = 8)
                    GOLD -> BenefitsList(numOfBenefits = 12)
                }
            }
        }
    }
}

@Composable
private fun BenefitsList(numOfBenefits: Int) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(numOfBenefits) {
            ElevatedCard {
                Text(
                    text = "Lorem ipsum dolor sit amet",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth(),
                )
            }
        }
    }
}

@Preview
@Composable
private fun FindOutMoreScreenPreview() {
    FindOutMoreScreen(onClose = {})
}
