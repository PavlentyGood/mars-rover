package ru.pavlentygood.marsrover

import java.util.LinkedList
import java.util.Queue

class Rover(
    val x: Int,
    private val ways: Queue<Way>
) {
    val way: Way = ways.element()

    fun step() = createRover(x = way.step(x))

    fun right() = createRover(ways = nextWays())

    private fun nextWays(): Queue<Way> {
        val ways = LinkedList(ways)
        val next = ways.remove()
        ways.add(next)
        return ways
    }

    fun left() = right().right().right()

    private fun createRover(x: Int = this.x, ways: Queue<Way> = this.ways) =
        Rover(x = x, ways = ways)
}
