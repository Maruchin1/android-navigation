package com.maruchin.data.categories

@JvmInline
value class Category(val name: String)

val sampleCategories = listOf(
    Category(name = "Electronics"),
    Category(name = "Jewelry"),
    Category(name = "Men's Clothing"),
    Category(name = "Women's Clothing"),
)
