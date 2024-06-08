package ru.pavlentygood.marsrover

data class Vector(
    val x: Int,
    val y: Int,
    val limit: Int,
    val side: Side
) {
    fun step(point: Point) =
        Point(
            x = stepBy(point.x, x),
            y = stepBy(point.y, y)
        )

    private fun stepBy(value: Int, offset: Int) =
        if (offset == 0 || value == limit) value else value + offset
}
