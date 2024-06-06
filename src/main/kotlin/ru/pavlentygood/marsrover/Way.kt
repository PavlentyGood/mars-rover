package ru.pavlentygood.marsrover

class Way(
    val direction: Direction,
    val limit: Int
) {
    fun step(value: Int) =
        if (value == limit) value
        else value + direction.offset
}
