package com.app.shoppinglistmvvm.data.repository

import com.app.shoppinglistmvvm.data.db.ShoppingDatabase
import com.app.shoppinglistmvvm.data.db.entities.ShoppingItem

class ShoppingRespository(private val db : ShoppingDatabase
) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItem() = db.getShoppingDao().getAllShoppingItem()

}