package ru.pavlentygood.marsrover

import ru.pavlentygood.marsrover.Action.*
import ru.pavlentygood.marsrover.Direction.*

class Rover(
    val x: Vector,
    val y: Vector,
    val direction: Direction,
) {
    fun doAction(action: Action) = when (action) {
        MOVE -> createRover(x = offsetX(), y = offsetY())
        RIGHT -> directed(direction.onRight())
        LEFT -> directed(direction.onLeft())
    }

    private fun offsetX() = when (direction) {
        EAST -> x.next()
        WEST -> x.prev()
        else -> x
    }

    private fun offsetY() = when (direction) {
        NORTH -> y.next()
        SOUTH -> y.prev()
        else -> y
    }

    private fun directed(direction: Direction) =
        createRover(direction = direction)

    private fun createRover(
        x: Vector = this.x,
        y: Vector = this.y,
        direction: Direction = this.direction) =
        Rover(
            x = x,
            y = y,
            direction = direction
        )
}
