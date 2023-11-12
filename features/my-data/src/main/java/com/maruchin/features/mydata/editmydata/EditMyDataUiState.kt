package com.maruchin.features.mydata.editmydata

internal data class EditMyDataUiState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val isSaved: Boolean = false,
)
