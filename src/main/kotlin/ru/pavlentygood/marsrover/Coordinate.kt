package ru.pavlentygood.marsrover

data class Coordinate(
    val value: Int,
    val limit: Int
) {
    fun add(offset: Int) =
        (value + offset).let {
            if (it < 0 || it > limit) this
            else Coordinate(it, limit)
        }

    // todo add factory with validation
}
