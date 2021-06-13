package com.app.shoppinglistmvvm.ui.shoppingList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.shoppinglistmvvm.R
import com.app.shoppinglistmvvm.data.db.ShoppingDatabase
import com.app.shoppinglistmvvm.data.db.entities.ShoppingItem
import com.app.shoppinglistmvvm.data.repository.ShoppingRespository
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.android.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity(),KodeinAware {

    override val kodein by kodein()
    private val factory : ShoppingViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

       /* val database = ShoppingDatabase(this)
        val repository = ShoppingRespository(database)
        val factory = ShoppingViewModelFactory(repository)*/
        val viewModel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(),viewModel)
        rvShoppingItem.layoutManager = LinearLayoutManager(this)
        rvShoppingItem.adapter = adapter

        viewModel.getAllShoppingItem().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })


        fab.setOnClickListener {
            AddShoppingItemDialog(this,object :AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }

            }).show()
        }
    }

}