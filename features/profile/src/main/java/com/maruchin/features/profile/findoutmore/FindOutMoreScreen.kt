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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.features.profile.R

private const val STANDARD = 0
private const val SILVER = 1
private const val GOLD = 2

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun FindOutMoreScreen(onCloseClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopBar(onCloseClick = onCloseClick)
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val pagerState = rememberFindOutPagerState()

            ExplanationText()
            TabRow(selectedTabIndex = pagerState.currentPage) {
                StandardTab(pagerState)
                SilverTab(pagerState)
                GoldTab(pagerState)
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
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(onCloseClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.find_out_more))
        },
        navigationIcon = {
            IconButton(onClick = onCloseClick) {
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }
        }
    )
}

@Composable
private fun ExplanationText() {
    Text(
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(horizontal = 40.dp, vertical = 16.dp)
    )
}

@Composable
private fun StandardTab(pagerState: FindOutMorePagerState) {
    Tab(
        selected = pagerState.isSelectedPage(STANDARD),
        onClick = { pagerState.selectPage(STANDARD) },
        text = {
            Text(text = stringResource(R.string.standard))
        },
    )
}

@Composable
private fun SilverTab(pagerState: FindOutMorePagerState) {
    Tab(
        selected = pagerState.isSelectedPage(SILVER),
        onClick = { pagerState.selectPage(SILVER) },
        text = {
            Text(text = stringResource(R.string.silver))
        },
    )
}

@Composable
private fun GoldTab(pagerState: FindOutMorePagerState) {
    Tab(
        selected = pagerState.isSelectedPage(GOLD),
        onClick = { pagerState.selectPage(GOLD) },
        text = {
            Text(text = stringResource(R.string.gold))
        },
    )
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
    FindOutMoreScreen(onCloseClick = {})
}
