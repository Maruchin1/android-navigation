package com.maruchin.data.categories

val sampleCategories = listOf(
    Category(
        id = "shoes",
        name = "Shoes",
        subcategories = listOf(
            Category(
                id = "shoes-all",
                name = "See all",
                subcategories = emptyList(),
            ),
            Category(
                id = "shoes-categories",
                name = "Categories",
                subcategories = listOf(
                    Category(
                        id = "shoes-categories-sneakers",
                        name = "Sneakers",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "shoes-categories-boots",
                        name = "Boots",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "shoes-categories-sandals",
                        name = "Sandals",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "shoes-categories-loafers",
                        name = "Loafers",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "shoes-categories-oxfords",
                        name = "Oxfords",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "shoes-categories-flip-flops",
                        name = "Flip Flops",
                        subcategories = emptyList(),
                    ),
                ),
            ),
            Category(
                id = "shoes-recommended",
                name = "Recommended",
                subcategories = listOf(
                    Category(
                        id = "shoes-recommended-summer",
                        name = "Summer",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "shoes-recommended-winter",
                        name = "Winter",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "shoes-recommended-autumn",
                        name = "Autumn",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "shoes-recommended-spring",
                        name = "Spring",
                        subcategories = emptyList(),
                    ),
                ),
            ),
            Category(
                id = "shoes-brands",
                name = "Brands",
                subcategories = listOf(
                    Category(
                        id = "shoes-brands-nike",
                        name = "Nike",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "shoes-brands-adidas",
                        name = "Adidas",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "shoes-brands-puma",
                        name = "Puma",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "shoes-brands-new-balance",
                        name = "New Balance",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "shoes-brands-reebok",
                        name = "Reebok",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "shoes-brands-asics",
                        name = "Asics",
                        subcategories = emptyList(),
                    ),
                ),
            ),
        )
    ),
    Category(
        id = "bags-and-suitcases",
        name = "Bags & Suitcases",
        subcategories = listOf(
            Category(
                id = "bags-and-suitcases-all",
                name = "See all",
                subcategories = emptyList(),
            ),
            Category(
                id = "bags-and-suitcases-mens-bags",
                name = "Men's bags",
                subcategories = listOf()
            ),
            Category(
                id = "bags-and-suitcases-suitcases",
                name = "Suitcases",
                subcategories = listOf()
            ),
            Category(
                id = "bags-and-suitcases-backpacks",
                name = "Backpacks",
                subcategories = listOf()
            ),
        )
    ),
    Category(
        id = "accessories-and-clothes",
        name = "Accessories & Clothes",
        subcategories = listOf(
            Category(
                id = "accessories-and-clothes-all",
                name = "See all",
                subcategories = emptyList(),
            ),
            Category(
                id = "accessories-and-clothes-for-shoes",
                name = "For shoes",
                subcategories = listOf(
                    Category(
                        id = "accessories-and-clothes-for-shoes-shoe-laces",
                        name = "Shoe laces",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "accessories-and-clothes-for-shoes-insoles",
                        name = "Insoles",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "accessories-and-clothes-for-shoes-shoe-care",
                        name = "Shoe care",
                        subcategories = emptyList(),
                    ),
                ),
            ),
            Category(
                id = "accessories-and-clothes-accessories",
                name = "Accessories",
                subcategories = listOf(
                    Category(
                        id = "accessories-and-clothes-accessories-belts",
                        name = "Belts",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "accessories-and-clothes-accessories-wallets",
                        name = "Wallets",
                        subcategories = emptyList(),
                    ),
                    Category(
                        id = "accessories-and-clothes-accessories-socks",
                        name = "Socks",
                        subcategories = emptyList(),
                    ),
                )
            ),
        )
    ),
    Category(
        id = "brands",
        name = "Brands",
        subcategories = listOf(
            Category(
                id = "brands-all",
                name = "See all",
                subcategories = emptyList(),
            ),
            Category(
                id = "brands-nike",
                name = "Nike",
                subcategories = emptyList(),
            ),
            Category(
                id = "brands-adidas",
                name = "Adidas",
                subcategories = emptyList(),
            ),
            Category(
                id = "brands-puma",
                name = "Puma",
                subcategories = emptyList(),
            ),
            Category(
                id = "brands-new-balance",
                name = "New Balance",
                subcategories = emptyList(),
            ),
            Category(
                id = "brands-reebok",
                name = "Reebok",
                subcategories = emptyList(),
            ),
            Category(
                id = "brands-asics",
                name = "Asics",
                subcategories = emptyList(),
            ),
        )
    )
)