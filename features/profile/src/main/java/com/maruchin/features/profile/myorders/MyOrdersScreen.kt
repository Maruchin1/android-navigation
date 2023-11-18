package com.maruchin.features.profile.myorders

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
internal fun MyOrdersScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopBar(onBackClick = onBackClick)
        }
    ) { padding ->
        Placeholder(padding)
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(onBackClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.my_orders))
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        }
    )
}

@Composable
private fun Placeholder(padding: PaddingValues) {
    ScreenContentPlaceholder(
        icon = Icons.Default.Folder,
        text = stringResource(R.string.there_are_no_orders_in_your_account_yet),
        modifier = Modifier.padding(padding)
    )
}

@Preview
@Composable
private fun MyOrdersScreenPreview() {
    MyOrdersScreen(onBackClick = {})
}
