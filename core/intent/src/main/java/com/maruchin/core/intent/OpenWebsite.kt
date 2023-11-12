package com.maruchin.core.intent

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

fun Context.openWebsite(uri: Uri) {
    CustomTabsIntent.Builder()
        .build()
        .launchUrl(this, uri)
}
