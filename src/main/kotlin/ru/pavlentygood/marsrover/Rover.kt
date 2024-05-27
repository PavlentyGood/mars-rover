package ru.pavlentygood.marsrover

import ru.pavlentygood.marsrover.Action.*
import ru.pavlentygood.marsrover.Direction.*

class Rover(
    val x: Int,
    val y: Int,
    val direction: Direction,
) {
    fun doAction(action: Action) = when (action) {
        MOVE -> Rover(x = x, y = y + 1, direction = direction)
        RIGHT -> Rover(
            x = x,
            y = y,
            direction = when (direction) {
                NORTH -> EAST
                EAST -> SOUTH
                SOUTH -> WEST
                WEST -> NORTH
            }
        )
        LEFT -> Rover(
            x = x,
            y = y,
            direction = when (direction) {
                NORTH -> WEST
                WEST -> SOUTH
                SOUTH -> EAST
                EAST -> NORTH
            }
        )
    }
}
