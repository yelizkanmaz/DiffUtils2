package com.example.diffutils

class ProductsRepo {
     val products
     get() = listOf(
         Products(1, "Süt", "1,20", 1),
         Products(2, "Kurabiye", "2,00", 5),
         Products(3, "Sabun", "5,00", 4),
         Products(4, "Tavuk", "7,00", 10),
         Products(5, "Soda", "8,00", 7),
         Products(6, "Kahve", "13,90", 8),
         Products(7, "Kraker", "3,00", 3),
         Products(8, "Oyuncak", "4,00", 2),
         Products(9, "Gazete", "2,50", 6),
         Products(10, "Çay", "17,00", 9)
     )

    //id'ye göre sıralıyoruz
    val sortedById: List<Products>
        get() = products.sortedBy { it.id }

    //isme göre sıralıyoruz
    val sortedByName: List<Products>
        get() = products.sortedBy { it.name }

    //Fiyata göre sıralıyoruz
    val sortedByPrice: List<Products>
        get() = products.sortedBy { it.price }

    //Stok durumuna göre sıralıyoruz
    val sortedByStock: List<Products>
        get() = products.sortedBy { it.stock }
}