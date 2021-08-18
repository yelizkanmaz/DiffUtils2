package com.example.diffutils

class ProductsRepo {

    private val products = listOf(
        Products(1, "Süt - 1,20 birim para - stok 10", "1,20", 10),
        Products(2, "Kurabiye - 2,00 birim para - stok 5", "2,00", 5),
        Products(3, "Dondurma - 10,00 birim para - stok 12", "10,00", 12),
        Products(4, "Su - 0,50 birim para - stok 20", "0,50", 20),
        Products(5, "Pizza - 15,00 birim para - stok 5", "15,00", 5),
        Products(6, "Köpek Maması - 50,00 birim p. - stok 8", "50,00", 8),
        Products(7, "Ekmek - 2,00 birim para - stok 11", "2,00", 11),
        Products(8, "Sabun - 5,00 birim para - stok 4", "5,00", 4),
        Products(9, "Tavuk - 7,00 birim para - stok 1", "7,00", 1),
        Products(10, "Kraker - 3,00 birim para - stok 3", "3,00", 3),
        Products(11, "Oyuncak - 4,00 birim para - stok 2", "4,00", 2),
        Products(12, "Gazete - 2,50 birim para - stok 6", "2,50", 6),
        Products(13, "Çay - 17,00 birim para - stok 9", "17,00", 9),
        Products(14, "Kahve - 13,90 birim para - stok 8", "13,90", 8),
        Products(15, "Soda - 8,00 birim para - stok 7", "8,00", 7)
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