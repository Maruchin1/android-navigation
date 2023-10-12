package com.maruchin.data.categories

data class Category(
    val id: CategoryId,
    val name: String,
    val subcategories: List<Category>,
) {

    val isFinal: Boolean
        get() = subcategories.isEmpty()
}

fun List<Category>.flatten(): List<Category> {
    return flatMap { category ->
        val subcategories = category.subcategories
        listOf(category) + subcategories.flatten()
    }
}

@JvmInline
value class CategoryId(val value: String)


