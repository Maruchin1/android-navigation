package com.maruchin.forms.datefield

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.platform.LocalFocusManager
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Stable
class DateFieldState(
    val datePickerState: DatePickerState,
    private val focusManager: FocusManager,
    isDialogOpen: Boolean = false
) {

    val selectedDate: LocalDate?
        get() = datePickerState.selectedDateMillis
            ?.let(Instant::ofEpochMilli)
            ?.atZone(ZoneId.systemDefault())
            ?.toLocalDate()

    val selectedDateText: String
        get() = selectedDate?.format(DateTimeFormatter.ISO_DATE) ?: ""

    val isValid: Boolean by derivedStateOf {
        datePickerState.selectedDateMillis != null
    }

    internal var isDialogOpen: Boolean by mutableStateOf(isDialogOpen)

    fun onFocusChange(focusState: FocusState) {
        isDialogOpen = focusState.isFocused
    }

    fun onDismiss() {
        focusManager.clearFocus()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
private fun dateFieldStateSaver(
    datePickerState: DatePickerState,
    focusManager: FocusManager
) = listSaver(
    save = {
        listOf(it.isDialogOpen)
    },
    restore = {
        DateFieldState(
            datePickerState = datePickerState,
            focusManager = focusManager,
            isDialogOpen = it[1]
        )
    }
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberDateFieldState(): DateFieldState {
    val datePickerState = rememberDatePickerState()
    val focusManager = LocalFocusManager.current

    return rememberSaveable(saver = dateFieldStateSaver(datePickerState, focusManager)) {
        DateFieldState(datePickerState, focusManager)
    }
}
