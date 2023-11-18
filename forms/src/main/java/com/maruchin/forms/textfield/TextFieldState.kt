package com.maruchin.forms.textfield

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Stable
class TextFieldState {

    var value: String by mutableStateOf("")

    val isValid: Boolean by derivedStateOf {
        value.isNotBlank()
    }
}

private val textFieldSaver = listSaver(
    save = {
        listOf(it.value)
    },
    restore = {
        TextFieldState().apply {
            value = it[0]
        }
    }
)

@Composable
fun rememberTextFieldState(): TextFieldState {
    return rememberSaveable(saver = textFieldSaver) {
        TextFieldState()
    }
}
