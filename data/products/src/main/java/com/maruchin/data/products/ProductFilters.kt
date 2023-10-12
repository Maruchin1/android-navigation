package com.maruchin.data.products

data class ProductFilters(
    val sorting: Sorting = Sorting.ALPHABETICALLY,
    val price: Price = Price(min = null, max = null),
) {

    operator fun invoke(products: List<Product>): List<Product> {
        return products
            .let(sorting::invoke)
            .let(price::invoke)
    }

    enum class Sorting {
        ALPHABETICALLY, PRICE_FROM_THE_LOWEST, PRICE_FROM_THE_HIGHEST;

        operator fun invoke(products: List<Product>): List<Product> {
            return when (this) {
                ALPHABETICALLY -> products.sortedBy { it.name }
                PRICE_FROM_THE_LOWEST -> products.sortedBy { it.price }
                PRICE_FROM_THE_HIGHEST -> products.sortedByDescending { it.price }
            }
        }
    }

    data class Price(val min: Float?, val max: Float?) {

        operator fun invoke(products: List<Product>): List<Product> {
            return products.filter { product ->
                product.price in (min ?: Float.MIN_VALUE)..(max ?: Float.MAX_VALUE)
            }
        }
    }
}