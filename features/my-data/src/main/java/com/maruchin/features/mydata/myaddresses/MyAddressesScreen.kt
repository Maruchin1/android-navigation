package com.maruchin.features.mydata.myaddresses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.data.addresses.AddressId
import com.maruchin.data.addresses.sampleAddress

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MyAddressesScreen(
    state: MyAddressesUiState,
    onBack: () -> Unit,
    onAddAddressClick: () -> Unit,
    onEditAddress: (AddressId) -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "My addresses")
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    TextButton(onClick = onAddAddressClick) {
                        Text(text = "Add")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            state.addresses.forEach { address ->
                AddressItem(
                    state = address,
                    onEditClick = { onEditAddress(address.id) }
                )
            }
        }
    }
}

@Composable
private fun AddressItem(state: AddressUiState, onEditClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = state.fullName, style = MaterialTheme.typography.titleMedium)
            Text(text = state.firstLine, style = MaterialTheme.typography.bodyMedium)
            Text(text = state.secondLine, style = MaterialTheme.typography.bodyMedium)
        }
        IconButton(onClick = onEditClick) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = null)
        }
    }
    Divider()
}

@Preview
@Composable
private fun MyAddressesScreenPreview() {
    MyAddressesScreen(
        state = MyAddressesUiState(
            addresses = listOf(AddressUiState(sampleAddress))
        ),
        onBack = {},
        onAddAddressClick = {},
        onEditAddress = {},
    )
}
