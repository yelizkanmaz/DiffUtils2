package com.example.diffutils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(productList: List<Products>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    val products = mutableListOf<Products>()

    init {
        products.addAll(productList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(product = products[position])
    }

    fun update(product: List<Products>) {
        this.products.addAll(product)

        val diffCallback = ProductsDiffCallback(this.products, product)
        val diffResult = DiffUtil.calculateDiff(diffCallback) //farklarını hesaplar

        this.products.clear()
        this.products.addAll(product)
        diffResult.dispatchUpdatesTo(this) //güncellemeleri adapter'a gönderir

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.findViewById(R.id.txtName)

        fun bind(product: Products) {
            name.text = product.name
        }
    }
}