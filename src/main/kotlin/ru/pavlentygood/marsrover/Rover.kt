package ru.pavlentygood.marsrover

class Rover(
    val x: Int,
    private val way: Way
) {
    val limit = way.limit
    val direction = way.direction

    fun step() = createRover(x = way.direction.step(this))

    fun right() = createRover(direction = way.direction.next())

    fun left() = right().right().right()

    private fun createRover(
        x: Int = this.x,
        limit: Int = this.way.limit,
        direction: Direction = this.way.direction
    ) =
        create(
            x = x,
            limit = limit,
            direction = direction
        )

    companion object {
        fun create(x: Int, limit: Int, direction: Direction) =
            Rover(
                x = x,
                way = Way(
                    direction = direction,
                    limit = limit
                )
            )
    }
}
