package com.example.myshoppinglistapp.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myshoppinglistapp.domain.models.ShoppingItem

@Composable
fun ShoppingItemEditor(item: ShoppingItem, onEditComplete: (String, Int) -> Unit) {

    var editedName by remember {
        mutableStateOf(item.name)
    }

    var editedQuantity by remember {
        mutableStateOf(item.quantity.toString())
    }
    var isEditing by remember { mutableStateOf(item.isEditing) }

    Row(modifier = Modifier.fillMaxWidth().background(Color.White)
        .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = Modifier
            .padding(8.dp)) {

            BasicTextField(value = editedName,
                onValueChange = {
                editedName = it
            },
                modifier = Modifier.wrapContentSize()
                    .padding(8.dp),
                singleLine = true)

            BasicTextField(value = editedQuantity, onValueChange = {
                editedQuantity = it
            }, modifier = Modifier.wrapContentSize()
                .padding(8.dp),
                singleLine = true)
        }

        Button(onClick = {

            isEditing = false
            onEditComplete(editedName,editedQuantity.toIntOrNull() ?: 1)
        })
        {
            Text(text = "Save")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewShoppingItemEditor(){

    ShoppingItemEditor(item = ShoppingItem(1,"Swathi",1), onEditComplete ={
        name,quantity ->
    } )
}