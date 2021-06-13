package com.app.shoppinglistmvvm

import android.app.Application
import com.app.shoppinglistmvvm.data.db.ShoppingDatabase
import com.app.shoppinglistmvvm.data.repository.ShoppingRespository
import com.app.shoppinglistmvvm.ui.shoppingList.ShoppingViewModel
import com.app.shoppinglistmvvm.ui.shoppingList.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ShoppingApplication : Application(),KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShoppingApplication))
        bind() from singleton { ShoppingDatabase(instance()) }
        bind() from singleton { ShoppingRespository(instance()) }
        bind() from provider {
            ShoppingViewModelFactory(instance())
        }

    }
}