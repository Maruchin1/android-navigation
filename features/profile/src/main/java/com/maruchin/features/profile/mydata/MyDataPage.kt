package com.maruchin.features.profile.mydata

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun MyDataPage(
    onOpenMyData: () -> Unit,
    onOpenMyOrders: () -> Unit,
    onOpenReturns: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        MyDataItem(text = "My data", onClick = onOpenMyData)
        MyDataItem(text = "My orders", onClick = onOpenMyOrders)
        MyDataItem(text = "Returns", onClick = onOpenReturns)
    }
}

@Composable
internal fun MyDataItem(text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onClick() }
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = text, style = MaterialTheme.typography.bodyLarge)
        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
    }
    Divider()
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun MyDataPagePreview() {
    MyDataPage(
        onOpenMyData = {},
        onOpenMyOrders = {},
        onOpenReturns = {},
    )
}
