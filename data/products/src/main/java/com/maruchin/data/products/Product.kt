package com.maruchin.data.products

import com.maruchin.data.categories.Category
import java.net.URL

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Float,
    val images: List<URL>,
    val category: Category,
    val rating: Rating,
)

val sampleProducts = listOf(
    Product(
        id = 1,
        title = "iPhone 13",
        description = "The iPhone 13 and iPhone 13 mini are smartphones designed, developed, and marketed by Apple Inc. They are the fourteenth-generation, lower-priced iPhones, succeeding the iPhone 12 and iPhone 12 mini, respectively. Apple CEO Tim Cook announced the devices alongside a new iPad and Apple Watch Series 7 during a virtual press event on September 14, 2021. Pre-orders began on September 17, 2021, and the devices became available on September 24, 2021.",
        price = 799f,
        images = listOf(URL("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/IPhone_13_Pro_Max_Gold.svg/1200px-IPhone_13_Pro_Max_Gold.svg.png")),
        category = Category(name = "electronics"),
        rating = Rating(4.5f, 100)
    ),
    Product(
        id = 2,
        title = "iPhone 13 Pro",
        description = "The iPhone 13 and iPhone 13 mini are smartphones designed, developed, and marketed by Apple Inc. They are the fourteenth-generation, lower-priced iPhones, succeeding the iPhone 12 and iPhone 12 mini, respectively. Apple CEO Tim Cook announced the devices alongside a new iPad and Apple Watch Series 7 during a virtual press event on September 14, 2021. Pre-orders began on September 17, 2021, and the devices became available on September 24, 2021.",
        price = 999f,
        images = listOf(URL("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/IPhone_13_Pro_Max_Gold.svg/1200px-IPhone_13_Pro_Max_Gold.svg.png")),
        category = Category(name = "electronics"),
        rating = Rating(4.5f, 100)
    ),
    Product(
        id = 3,
        title = "iPhone 13 Pro Max",
        description = "The iPhone 13 and iPhone 13 mini are smartphones designed, developed, and marketed by Apple Inc. They are the fourteenth-generation, lower-priced iPhones, succeeding the iPhone 12 and iPhone 12 mini, respectively. Apple CEO Tim Cook announced the devices alongside a new iPad and Apple Watch Series 7 during a virtual press event on September 14, 2021. Pre-orders began on September 17, 2021, and the devices became available on September 24, 2021.",
        price = 1099f,
        images = listOf(URL("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/IPhone_13_Pro_Max_Gold.svg/1200px-IPhone_13_Pro_Max_Gold.svg.png")),
        category = Category(name = "electronics"),
        rating = Rating(4.5f, 100)
    ),
    Product(
        id = 4,
        title = "iPhone 13 mini",
        description = "The iPhone 13 and iPhone 13 mini are smartphones designed, developed, and marketed by Apple Inc. They are the fourteenth-generation, lower-priced iPhones, succeeding the iPhone 12 and iPhone 12 mini, respectively. Apple CEO Tim Cook announced the devices alongside a new iPad and Apple Watch Series 7 during a virtual press event on September 14, 2021. Pre-orders began on September 17, 2021, and the devices became available on September 24, 2021.",
        price = 699f,
        images = listOf(URL("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/IPhone_13_Pro_Max_Gold.svg/1200px-IPhone_13_Pro_Max_Gold.svg.png")),
        category = Category(name = "electronics"),
        rating = Rating(4.5f, 100)
    ),
)
