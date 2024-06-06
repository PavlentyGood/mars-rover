package ru.pavlentygood.marsrover

class Rover(
    val x: Int,
    val limit: Int,
    val direction: Direction
) {
    fun step() = createRover(x = direction.step(this))

    fun right() = createRover(direction = direction.next())

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
