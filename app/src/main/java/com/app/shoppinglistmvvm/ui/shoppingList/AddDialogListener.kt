package com.app.shoppinglistmvvm.ui.shoppingList

import com.app.shoppinglistmvvm.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}