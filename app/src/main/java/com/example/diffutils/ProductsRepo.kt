package com.example.diffutils

class ProductsRepo {

     val products
     get() = listOf(
         Products(1, "Süt", "1,20", 10),
         Products(2, "Kurabiye", "2,00", 5),
         Products(3, "Dondurma", "10,00", 12),
         Products(4, "Su", "0,50", 20),
         Products(5, "Pizza", "15,00", 5),
         Products(6, "Köpekk 8", "50,00", 8),
         Products(7, "Ekmek", "2,00", 11),
         Products(8, "Sabun", "5,00", 4),
         Products(9, "Tavuk", "7,00", 1),
         Products(10, "Kraker", "3,00", 3),
         Products(11, "Oyuncak", "4,00", 2),
         Products(12, "Gazete", "2,50", 6),
         Products(13, "Çay", "17,00", 9),
         Products(14, "Kahve", "13,90", 8),
         Products(15, "Soda", "8,00", 7)
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