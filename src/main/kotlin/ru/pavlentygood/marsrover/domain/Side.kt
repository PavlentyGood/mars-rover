package ru.pavlentygood.marsrover.domain

enum class Side(
    val xOffset: Int,
    val yOffset: Int
) {
    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    fun next() = values()[(ordinal + 1) % values().size]
}
