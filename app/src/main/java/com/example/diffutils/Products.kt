package com.example.diffutils

data class Products(val id: Int, val name: String, val price: String, var stock: Int) {
    override fun toString(): String {
        return "$name - $price birim para - stok $stock"
    }
}
