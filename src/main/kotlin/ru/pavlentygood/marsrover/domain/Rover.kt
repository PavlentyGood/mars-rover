package ru.pavlentygood.marsrover.domain

typealias Action = (Rover) -> Rover

data class Rover(
    val x: Coordinate,
    val y: Coordinate,
    val side: Side
) {
    fun step() =
        createRover(
            x = x.add(side.xOffset),
            y = y.add(side.yOffset)
        )

    fun right() =
        createRover(
            side = side.next()
        )

    fun left() =
        createRover(
            side = side.next().next().next()
        )

    private fun createRover(
        x: Coordinate = this.x,
        y: Coordinate = this.y,
        side: Side = this.side
    ) = Rover(x, y, side)

    companion object {
        fun create(width: Int, height: Int, x: Int, y: Int, side: Side) =
            Rover(
                x = Coordinate.create(value = x, limit = width),
                y = Coordinate.create(value = y, limit = height),
                side = side
            )
    }
}
