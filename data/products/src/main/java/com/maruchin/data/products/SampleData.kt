package com.maruchin.data.products

import com.maruchin.data.categories.flatten
import com.maruchin.data.categories.sampleCategories
import java.net.URL
import kotlin.random.Random

val categoriesIds = sampleCategories.flatten().filter { it.isFinal }.map { it.id }

val sampleProducts = (0..1_000).map { index ->
    Product(
        id = ProductId(index.toString()),
        name = "Lorem ipsum dolor sit amet",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        price = (1..2_500).random().toFloat(),
        images = (1..5).map { URL("https://sothebys-com.brightspotcdn.com/dims4/default/8552506/2147483647/strip/true/crop/663x576+0+0/resize/684x594!/quality/90/?url=http%3A%2F%2Fsothebys-brightspot.s3.amazonaws.com%2Fdotcom%2F48%2Ff5%2F50f7ce56440598d5f02c1de64fa5%2Fsothebys-md.brightspotcdn.jpg") },
        categoryId = categoriesIds.random(),
        rating = Rating(rate = 3.5f, count = 128),
        isFavorite = Random.nextBoolean(),
    )
}



