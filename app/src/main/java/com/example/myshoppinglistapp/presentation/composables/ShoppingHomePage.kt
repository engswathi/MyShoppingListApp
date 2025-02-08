package com.example.myshoppinglistapp.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myshoppinglistapp.domain.models.ShoppingItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingHomePage(modifier: Modifier = Modifier) {

    var sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }
    var showAlert by remember { mutableStateOf(false) }
    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier.height(50.dp))
        Button(onClick = {
            showAlert = true
        }, modifier = modifier.align(Alignment.CenterHorizontally)) {

            Text(text = "Add Item")

        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(sItems) {

            }

        }

    }

    if (showAlert) {
        AlertDialog(
            onDismissRequest = { showAlert = false },
            title = { Text("Add an Item") },
            text = {
                Column {
                    Text("Please enter item details:")
                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = itemName,
                        onValueChange = { itemName = it },
                        label = { Text("Item Name") },
                        modifier = Modifier.fillMaxWidth().padding(8.dp),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = itemQuantity,
                        onValueChange = { itemQuantity = it },
                        label = { Text("Quantity") },
                        modifier = Modifier.fillMaxWidth().padding(8.dp)
                    )
                }
            },
            confirmButton = {
                Button(onClick = {
                    if (itemName.isNotBlank()){
                    val item = ShoppingItem(id = sItems.size+1,
                        name = itemName,
                        quantity = itemQuantity.toInt())
                        sItems = sItems + item
                        itemName = ""
                        itemQuantity = ""
                    }
                    showAlert = false
                }) {
                    Text("Add")
                }
            },
            dismissButton = {
                Button(onClick = { showAlert = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewShoppingHomePage() {
    ShoppingHomePage()
}
