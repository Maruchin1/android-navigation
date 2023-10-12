package com.maruchin.data.categories

data class Category(
    val id: CategoryId,
    val name: String,
    val subcategories: List<Category>,
) {

    val isFinal: Boolean
        get() = subcategories.isEmpty()
}

@JvmInline
value class CategoryId(val value: String)


