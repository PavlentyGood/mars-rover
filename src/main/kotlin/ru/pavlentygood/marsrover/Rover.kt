package ru.pavlentygood.marsrover

import ru.pavlentygood.marsrover.Action.*
import ru.pavlentygood.marsrover.Direction.*

class Rover(
    val x: Int,
    val y: Int,
    val direction: Direction,
) {
    fun doAction(action: Action) = when (action) {
        MOVE -> Rover(
            x = when (direction) {
                EAST -> x + 1
                WEST -> x - 1
                else -> x
            },
            y = when (direction) {
                NORTH -> y + 1
                SOUTH -> y - 1
                else -> y
            },
            direction = direction
        )
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
