package ru.pavlentygood.marsrover

import ru.pavlentygood.marsrover.Side.*

data class Rover(
    val current: Coordinate,
    val x: Coordinate,
    val y: Coordinate
) {
    val side =
        if (current == x) {
            if (x.current.offset == FORWARD) EAST
            else WEST
        } else {
            if (y.current.offset == FORWARD) NORTH
            else SOUTH
        }

    fun step() =
        current.step().let {
            Rover(
                current = it,
                x = if (current == x) it else x,
                y = if (current == y) it else y
            )
        }

    fun turn() =
        Rover(
            current = (if (current == x) y else x).reversed(),
            x = if (current == x) x else x.reversed(),
            y = if (current == y) y else y.reversed()
        )
}
