package com.maruchin.features.mydata.mydata

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MyDataScreen(
    state: MyDataUiState,
    onBack: () -> Unit,
    onPersonalDataClick: () -> Unit,
    onMyAddressesClick: () -> Unit,
    onChangePasswordClick: () -> Unit,
    onDeleteAccountClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "My data")
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onPersonalDataClick() }
                    .padding(16.dp),
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
                    Text(text = state.fullName, style = MaterialTheme.typography.titleLarge)
                    Text(text = state.email, style = MaterialTheme.typography.bodyMedium)
                    Text(text = state.phoneNumber, style = MaterialTheme.typography.bodyMedium)
                }
                Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
            }
            Divider()
            MyDataItem(text = "My addresses", onClick = onMyAddressesClick)
            MyDataItem(text = "Change password", onClick = onChangePasswordClick)
            MyDataItem(text = "Delete account", onClick = onDeleteAccountClick)
        }
    }
}

@Composable
private fun MyDataItem(text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = text, style = MaterialTheme.typography.bodyLarge)
        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
    }
    Divider()
}

@Preview
@Composable
private fun MyDataScreenPreview() {
    MyDataScreen(
        state = MyDataUiState(
            fullName = "John Doe",
            email = "john.doe@gmail.com",
            phoneNumber = "+48 123 456 789",
        ),
        onBack = {},
        onPersonalDataClick = {},
        onMyAddressesClick = {},
        onChangePasswordClick = {},
        onDeleteAccountClick = {},
    )
}
