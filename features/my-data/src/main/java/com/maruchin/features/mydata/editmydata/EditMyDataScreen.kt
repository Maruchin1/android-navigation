package com.maruchin.features.mydata.editmydata

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.forms.personaldataform.PersonalDataForm
import com.maruchin.forms.personaldataform.rememberPersonalDataFormState
import com.maruchin.data.user.PersonalData
import com.maruchin.data.user.sampleLoggedUser
import com.maruchin.features.mydata.R

@Composable
internal fun EditMyDataScreen(
    personalData: PersonalData?,
    onCloseClick: () -> Unit,
    onSaveClick: (PersonalData) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(onCloseClick = onCloseClick)
        }
    ) { padding ->
        if (personalData == null) return@Scaffold

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            val formState = rememberPersonalDataFormState()

            LaunchedEffect(personalData) {
                formState.personalData = personalData
            }

            PersonalDataForm(
                modifier = Modifier.padding(16.dp),
                state = formState,
            )
            Spacer(modifier = Modifier.weight(1f))
            SaveButton(
                onClick = {
                    onSaveClick(formState.personalData)
                }
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(onCloseClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.my_data))
        },
        navigationIcon = {
            IconButton(onClick = onCloseClick) {
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }
        }
    )
}

@Composable
private fun SaveButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(text = stringResource(R.string.save))
    }
}

@Preview
@Composable
private fun EditMyDataScreenPreview() {
    EditMyDataScreen(
        personalData = sampleLoggedUser.personalData,
        onCloseClick = {},
        onSaveClick = {},
    )
}
