package ru.pavlentygood.marsrover

data class Vector(
    val x: Int,
    val y: Int,
    val limit: Int,
    val side: Side
) {
    fun step(x: Int, y: Int) = listOf(
        stepBy(x, this.x),
        stepBy(y, this.y)
    )

    private fun stepBy(v: Int, offset: Int) =
        if (offset == 0 || v == limit) v else v + offset
}
