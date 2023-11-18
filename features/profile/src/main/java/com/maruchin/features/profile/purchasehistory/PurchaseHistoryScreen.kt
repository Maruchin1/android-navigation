package com.maruchin.features.profile.purchasehistory

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maruchin.ui.ScreenContentPlaceholder
import com.maruchin.features.profile.R

@Composable
internal fun PurchaseHistoryScreen(onCloseClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopBar(onCloseClick = onCloseClick)
        }
    ) { padding ->
        Placeholder(padding)
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(onCloseClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.purchase_history))
        },
        navigationIcon = {
            IconButton(onClick = onCloseClick) {
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }
        }
    )
}

@Composable
private fun Placeholder(padding: PaddingValues) {
    ScreenContentPlaceholder(
        icon = Icons.Default.Folder,
        text = stringResource(R.string.purchase_history_placeholder),
        modifier = Modifier.padding(padding)
    )
}

@Preview
@Composable
private fun PurchaseHistoryScreenPreview() {
    PurchaseHistoryScreen(onCloseClick = {})
}