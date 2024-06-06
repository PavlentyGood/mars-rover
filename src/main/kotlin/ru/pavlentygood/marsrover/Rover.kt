package ru.pavlentygood.marsrover

class Rover(
    val x: Int,
    val way: Way,
    private val ways: Map<Direction, Way>
) {
    fun step() = createRover(x = way.step(x))

    fun right() = createRover(way = ways[way.direction.next()]!!)

    fun left() = right().right().right()

    private fun createRover(x: Int = this.x, way: Way = this.way, ways: Map<Direction, Way> = this.ways) =
        Rover(x = x, way = way, ways = ways)
}
