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
        MOVE -> Rover(
            width = width,
            height = height,
            x = when (direction) {
                EAST -> if (x < width) x + 1 else 0
                WEST -> if (x > 0) x - 1 else 0
                else -> x
            },
            y = when (direction) {
                NORTH -> if (y < height) y + 1 else 0
                SOUTH -> if (y > 0) y - 1 else 0
                else -> y
            },
            direction = direction
        )
        RIGHT -> directed(direction.onRight())
        LEFT -> directed(direction.onLeft())
    }

    private fun directed(direction: Direction) = Rover(
        width = width,
        height = height,
        x = x,
        y = y,
        direction = direction
    )
}
