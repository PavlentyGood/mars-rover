package ru.pavlentygood.marsrover

import ru.pavlentygood.marsrover.Action.*
import ru.pavlentygood.marsrover.Direction.*

class Rover(
    val width: Int,
    val height: Int,
    val x: Int,
    val y: Int,
    val direction: Direction,
) {
    fun doAction(action: Action) = when (action) {
        MOVE -> moved()
        RIGHT -> directed(direction.onRight())
        LEFT -> directed(direction.onLeft())
    }

    private fun moved() =
        createRover(
            x = x + nextOffsetX(),
            y = y + nextOffsetY()
        )

    private fun nextOffsetX() = when (direction) {
        EAST -> if (x < width) 1 else 0
        WEST -> if (x > 0) -1 else 0
        else -> 0
    }

    private fun nextOffsetY() =  when (direction) {
        NORTH -> if (y < height) 1 else 0
        SOUTH -> if (y > 0) -1 else 0
        else -> 0
    }

    private fun directed(direction: Direction) =
        createRover(direction = direction)

    private fun createRover(x: Int = this.x, y: Int = this.y, direction: Direction = this.direction) =
        Rover(
            width = width,
            height = height,
            x = x,
            y = y,
            direction = direction
        )
}
