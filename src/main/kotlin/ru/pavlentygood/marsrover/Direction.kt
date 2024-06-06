package ru.pavlentygood.marsrover

enum class Direction(
    val offset: Int
) {
    EAST(1),
    WEST(-1);

    fun next() = values()[(ordinal + 1) % values().size]
}
