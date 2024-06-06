package ru.pavlentygood.marsrover

class Rover(
    val x: Int,
    val limit: Int,
    val direction: Direction = Direction.EAST
) {
    fun step() = createRover(x = if (x == limit) x else x + direction.offset)

    fun right() = createRover(direction = Direction.values()[(direction.ordinal + 1) % Direction.values().size])

    fun left() = right().right().right()

    private fun createRover(
        x: Int = this.x,
        limit: Int = this.limit,
        direction: Direction = this.direction
    ) =
        Rover(
            x = x,
            limit = limit,
            direction = direction
        )
}
