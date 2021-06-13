package com.app.shoppinglistmvvm.ui.shoppingList

import androidx.lifecycle.ViewModel
import com.app.shoppinglistmvvm.data.db.entities.ShoppingItem
import com.app.shoppinglistmvvm.data.repository.ShoppingRespository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(val repository : ShoppingRespository): ViewModel() {
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItem()=repository.getAllShoppingItem()

}