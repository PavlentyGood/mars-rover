package ru.pavlentygood.marsrover

data class Rover(
    val current: Coordinate,
    val other: Coordinate
) {
    fun step() =
        Rover(
            current = current.step(),
            other = other
        )

    fun turn() =
       Rover(
            current = other.reversed(),
            other = current
        )
}
