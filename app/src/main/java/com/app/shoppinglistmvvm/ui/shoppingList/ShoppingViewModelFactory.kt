package com.app.shoppinglistmvvm.ui.shoppingList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.shoppinglistmvvm.data.repository.ShoppingRespository

@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory (
    private val repository : ShoppingRespository
        ):ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
        }