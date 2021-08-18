package com.example.diffutils

import androidx.recyclerview.widget.DiffUtil

class ProductsDiffCallback(private val oldList: List<Products>,
                           private val newList: List<Products>
) : DiffUtil.Callback() {

    //eski liste  boyutu
    override fun getOldListSize() = oldList.size

    //yeni liste boyutu
    override fun getNewListSize() = newList.size

    //elemanlar aynı mı
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    //obje içindeki detaylar aynı mı (stok)
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].stock == newList[newItemPosition].stock
    }
}
