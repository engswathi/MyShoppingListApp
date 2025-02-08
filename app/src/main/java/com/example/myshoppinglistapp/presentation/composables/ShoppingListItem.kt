package com.example.myshoppinglistapp.presentation.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myshoppinglistapp.domain.models.ShoppingItem

@Composable
fun ShoppingListItem(item: ShoppingItem,
                     onEditClick : () -> Unit,
                     onDeleteClick : () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(border = BorderStroke(2.dp, color = Color.Gray),
                shape = RoundedCornerShape(20)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(text = item.name, modifier = Modifier.padding(8.dp))
        Text(text = "Qty: ${item.quantity}",
            modifier = Modifier.padding(8.dp))

        Row {
            IconButton(onClick = onEditClick) {

                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
            }

            IconButton(onClick = onDeleteClick) {

                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
            }
        }


    }
}






