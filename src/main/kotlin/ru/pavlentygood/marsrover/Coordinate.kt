package ru.pavlentygood.marsrover

data class Coordinate(
    val value: Int,
    val current: Way,
    val other: Way
) {
    fun step() =
        Coordinate(
            value = current.step(value),
            current = current,
            other = other
        )

    fun reversed() =
        Coordinate(
            value = value,
            current = other,
            other = current
        )
}
