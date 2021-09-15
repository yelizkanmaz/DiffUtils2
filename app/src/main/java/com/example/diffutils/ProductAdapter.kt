package com.example.diffutils

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(productList: List<Products>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    val oldList = mutableListOf<Products>()

    init {
        oldList.addAll(productList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = oldList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(product = oldList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(newList: List<Products>) {
        val diffCallback = ProductsDiffCallback(oldList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.oldList.clear()
        this.oldList.addAll(newList)

        diffResult.dispatchUpdatesTo(this) //güncellemeleri adapter'a gönderir

        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.txtName)
        fun bind(product: Products) {
            name.text = product.toString()
        }
    }
}