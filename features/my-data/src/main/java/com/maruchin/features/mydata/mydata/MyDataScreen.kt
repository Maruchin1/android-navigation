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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.data.user.PersonalData
import com.maruchin.features.mydata.R

@Composable
internal fun MyDataScreen(
    personalData: PersonalData?,
    onBackClick: () -> Unit,
    onPersonalDataClick: () -> Unit,
    onMyAddressesClick: () -> Unit,
    onChangePasswordClick: () -> Unit,
    onDeleteAccountClick: () -> Unit,
    onLogoutClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar(onBackClick)
        }
    ) { padding ->
        if (personalData == null) return@Scaffold

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            PersonalDataSection(personalData = personalData, onClick = onPersonalDataClick)
            Divider()
            MyAddressesItem(onClick = onMyAddressesClick)
            ChangePasswordItem(onClick = onChangePasswordClick)
            DeleteAccountItem(onClick = onDeleteAccountClick)
            LogoutItem(onClick = onLogoutClick)
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(onBackClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.my_data))
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        }
    )
}

@Composable
private fun PersonalDataSection(personalData: PersonalData, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Text(
                text = "${personalData.firstName} ${personalData.lastName}",
                style = MaterialTheme.typography.titleLarge
            )
            Text(text = personalData.email, style = MaterialTheme.typography.bodyMedium)
            Text(
                text = personalData.phoneNumber,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
    }
}

@Composable
private fun MyAddressesItem(onClick: () -> Unit) {
    MyDataItem(text = stringResource(R.string.my_addresses), onClick = onClick)
}

@Composable
private fun ChangePasswordItem(onClick: () -> Unit) {
    MyDataItem(
        text = stringResource(R.string.change_password),
        onClick = onClick
    )
}

@Composable
private fun DeleteAccountItem(onClick: () -> Unit) {
    MyDataItem(
        text = stringResource(R.string.delete_account),
        onClick = onClick
    )
}

@Composable
private fun LogoutItem(onClick: () -> Unit) {
    MyDataItem(text = stringResource(R.string.logout), onClick = onClick)
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
        personalData = PersonalData(
            firstName = "John",
            lastName = "Doe",
            email = "john.doe@gmail.com",
            phoneNumber = "+48 123 456 789",
        ),
        onBackClick = {},
        onPersonalDataClick = {},
        onMyAddressesClick = {},
        onChangePasswordClick = {},
        onDeleteAccountClick = {},
        onLogoutClick = {},
    )
}
