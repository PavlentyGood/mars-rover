package ru.pavlentygood.marsrover

data class Coordinate(
    val value: Int,
    val currentWay: Way,
    val forward: Way,
    val backward: Way
) {
    fun step() =
        Coordinate(
            value = currentWay.step(value),
            currentWay = currentWay,
            forward = forward,
            backward = backward
        )

    fun reversed() = Coordinate(
        value = value,
        currentWay = if (currentWay == forward) backward else forward,
        forward = forward,
        backward = backward
    )
}
