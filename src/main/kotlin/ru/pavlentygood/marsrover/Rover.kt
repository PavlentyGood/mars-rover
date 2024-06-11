package ru.pavlentygood.marsrover

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
}
