package ru.pavlentygood.marsrover

data class Rover(
    val current: Coordinate,
    val x: Coordinate,
    val y: Coordinate
) {
    fun step() =
        if (current == x) createRover(x = current.step())
        else createRover(y = current.step())

    fun turn() =
        createRover(
            coordinate = (if (current == x) y else x).reversed()
        )

    private fun createRover(
        coordinate: Coordinate = this.current,
        x: Coordinate = this.x,
        y: Coordinate = this.y
    ) =
        Rover(
            current = coordinate,
            x = x,
            y = y
        )
}
