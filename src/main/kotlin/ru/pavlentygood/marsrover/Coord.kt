package ru.pavlentygood.marsrover

data class Coord(
    val value: Int,
    val limit: Int
) {
    fun add(offset: Int) =
        (value + offset).let {
            if (it < 0 || it > limit) this
            else Coord(it, limit)
        }

    // todo add factory with validation
}
