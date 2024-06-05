package ru.pavlentygood.marsrover

const val NEXT = 1
const val MOVE = 0

class Rover(
    val x: Int,
    val limit: Int
) {
    fun step() =
        Rover(
            x = if (x == limit) x else x + NEXT,
            limit = limit
        )

    fun execute(rover: Rover = this, actions: List<Int>): Rover =
        if (actions.isEmpty()) rover
        else execute(rover.step(), actions.drop(1))
}
