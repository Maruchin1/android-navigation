package com.maruchin.core.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun OrderProductItem(
    @DrawableRes image: Int,
    name: String,
    price: Double,
    quantity: Int,
    onClick: () -> Unit,
    onQuantityClick: (() -> Unit)? = null,
    onDeleteClick: (() -> Unit)? = null,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        OutlinedCard(modifier = Modifier.weight(1f)) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(2f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = name, style = MaterialTheme.typography.titleMedium)
            Text(text = "$price")
            Row {
                AssistChip(
                    onClick = { onQuantityClick?.invoke() },
                    label = {
                        Text(text = "x$quantity")
                    },
                    trailingIcon = onQuantityClick?.let {
                        {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null
                            )
                        }
                    },
                    enabled = onQuantityClick != null,
                )
                Spacer(modifier = Modifier.width(8.dp))
                if (onDeleteClick != null) {
                    AssistChip(
                        onClick = onDeleteClick,
                        label = {
                            Text(text = "Delete")
                        },
                        trailingIcon = {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                        }
                    )
                }
            }
        }
    }
    Divider(modifier = Modifier.padding(horizontal = 16.dp))
}