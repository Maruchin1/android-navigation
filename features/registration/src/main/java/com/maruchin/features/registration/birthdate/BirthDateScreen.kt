package com.maruchin.features.registration.birthdate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maruchin.features.registration.R
import com.maruchin.forms.datefield.DateField
import com.maruchin.forms.datefield.rememberDateFieldState
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun BirthDateScreen(
    onCloseClick: () -> Unit,
    onSaveBirthDateClick: (LocalDate) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(R.string.register))
                },
                navigationIcon = {
                    IconButton(onClick = onCloseClick) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val dateFieldState = rememberDateFieldState()

            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.CardGiftcard,
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Text(
                text = "Welcome in in the club",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Text(
                text = "Enter your date of birth to get discounts on your birthday",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            DateField(
                label = stringResource(R.string.birth_date),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                state = dateFieldState
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { dateFieldState.selectedDate?.let(onSaveBirthDateClick) },
                enabled = dateFieldState.isValid,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = stringResource(R.string.save_birth_date))
            }
        }
    }
}

@Preview
@Composable
private fun BirthDateScreenPreview() {
    BirthDateScreen(onCloseClick = {}, onSaveBirthDateClick = {})
}