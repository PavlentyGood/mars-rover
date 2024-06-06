package ru.pavlentygood.marsrover

class Rover(
    val x: Int,
    val way: Way,
    private val forward: Way,
    private val backward: Way
) {
    fun step() = createRover(x = way.step(x))

    fun turn() = createRover(way = if (way == forward) backward else forward)

    private fun createRover(x: Int = this.x, way: Way = this.way) =
        Rover(x = x, way = way, forward = forward, backward = backward)
}
