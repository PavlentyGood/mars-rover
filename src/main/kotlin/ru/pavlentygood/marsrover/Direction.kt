package ru.pavlentygood.marsrover

enum class Direction(
    val offset: Int
) {
    EAST(1),
    SOUTH(0),
    WEST(-1),
    NORTH(0);

    fun next() = values()[(ordinal + 1) % values().size]
}
