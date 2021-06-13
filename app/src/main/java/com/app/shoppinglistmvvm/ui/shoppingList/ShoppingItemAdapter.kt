package com.app.shoppinglistmvvm.ui.shoppingList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.shoppinglistmvvm.data.db.entities.ShoppingItem
import com.app.shoppinglistmvvm.databinding.ShoppingItemBinding

class ShoppingItemAdapter(var items:List<ShoppingItem>, private val viewModel : ShoppingViewModel) : RecyclerView.Adapter<ShoppingItemAdapter.MyHolder>() {

    private lateinit var binding : ShoppingItemBinding

    inner class MyHolder(val binding: ShoppingItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data:ShoppingItem)= with(itemView){
          binding.tvName.text = data.name
          binding.tvAmount.text = data.amount.toString()

          binding.tvDelete.setOnClickListener {
              viewModel.delete(data)
          }

          binding.tvMinus.setOnClickListener {
              if (data.amount > 0){
                  data.amount--
                  viewModel.upsert(data)
              }else{
                  viewModel.delete(data)
              }


          }

          binding.tvPlus.setOnClickListener {
              data.amount++
              viewModel.upsert(data)
          }



        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShoppingItemAdapter.MyHolder {
        binding = ShoppingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingItemAdapter.MyHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
       return items.size
    }
}