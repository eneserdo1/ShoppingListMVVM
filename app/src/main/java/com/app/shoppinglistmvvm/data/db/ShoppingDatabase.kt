package com.app.shoppinglistmvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.shoppinglistmvvm.data.db.entities.ShoppingItem
import org.kodein.di.Volatile

@Database(
    entities = [ShoppingItem::class],
    version = 1,
    exportSchema = false
)
abstract class ShoppingDatabase : RoomDatabase(){

    abstract fun getShoppingDao(): ShoppingDao

    companion object{
        @Volatile
        private var instance: ShoppingDatabase?=null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance?: createDatabase(context).also { instance =it }
        }
        private fun createDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,
            ShoppingDatabase::class.java,"ShoppingDb.db").build()
    }

}