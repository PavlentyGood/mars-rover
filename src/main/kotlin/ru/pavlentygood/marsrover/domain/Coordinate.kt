package ru.pavlentygood.marsrover.domain

const val MIN_LIMIT = 0

data class Coordinate(
    val value: Int,
    val limit: Int
) {
    fun add(offset: Int) =
        (value + offset).let {
            if (it < MIN_LIMIT || it > limit) this
            else Coordinate(it, limit)
        }

    // todo add factory with validation
}
