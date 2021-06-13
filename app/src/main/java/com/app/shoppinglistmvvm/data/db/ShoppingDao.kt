package com.app.shoppinglistmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.app.shoppinglistmvvm.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItem():LiveData<List<ShoppingItem>>
}