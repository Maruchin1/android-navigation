package com.maruchin.data.payments

import androidx.annotation.DrawableRes

data class Payment(
    @DrawableRes
    val logo: Int,
    val name: String,
)