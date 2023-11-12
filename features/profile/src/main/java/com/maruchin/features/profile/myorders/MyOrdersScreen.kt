package com.maruchin.features.profile.myorders

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
import androidx.compose.ui.tooling.preview.Preview
import com.maruchin.core.ui.ScreenContentPlaceholder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MyOrdersScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "My orders")
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        ScreenContentPlaceholder(
            icon = Icons.Default.Folder,
            text = "There are no orders in your account yet",
            modifier = Modifier.padding(padding)
        )
    }
}

@Preview
@Composable
private fun MyOrdersScreenPreview() {
    MyOrdersScreen(onBack = {})
}
