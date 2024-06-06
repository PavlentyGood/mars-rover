package ru.pavlentygood.marsrover

enum class Direction(
    val offset: Int,
    val limit: (Rover) -> Int
) {
    EAST(1, Rover::limit),
    SOUTH(0, { 0 }),
    WEST(-1, { 0 }),
    NORTH(0, { 0 });

    fun next() = values()[(ordinal + 1) % values().size]

    fun step(rover: Rover) = if (rover.x == limit(rover)) rover.x else rover.x + offset
}
