package com.maruchin.data.products

data class Rating(val rate: Float, val count: Int) {

    val stars: List<STAR>
        get() = (1..MAX_RATE).map { index ->
            when {
                index <= rate -> STAR.STAR
                index - 1 < rate -> STAR.HALF_STAR
                else -> STAR.EMPTY_STAR
            }
        }

    enum class STAR {
        STAR, HALF_STAR, EMPTY_STAR
    }

    companion object {
        const val MAX_RATE = 5
    }
}
