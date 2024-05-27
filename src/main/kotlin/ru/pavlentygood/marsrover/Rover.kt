package ru.pavlentygood.marsrover

import ru.pavlentygood.marsrover.Direction.*

class Rover(
    var x: Int,
    var y: Int,
    var direction: Direction
) {
    fun doAction(action: Action) {
        when (action) {
            Action.MOVE -> y++
            Action.RIGHT -> direction = when (direction) {
                NORTH -> EAST
                EAST -> SOUTH
                SOUTH -> WEST
                WEST -> NORTH
            }
        }
    }
}
