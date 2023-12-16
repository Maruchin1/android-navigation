package com.maruchin.data.user

import java.net.URL
import java.time.LocalDate

data class ClubData(
    val cardBarCode: URL,
    val clubLevel: ClubLevel,
    val birthDate: LocalDate?,
)