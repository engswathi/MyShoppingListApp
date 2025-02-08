package com.example.myshoppinglistapp.domain.models

data class ShoppingItem(val id : Int,
                        var name : String,
                        var quantity : Int,
                        var isEditing : Boolean = false)
