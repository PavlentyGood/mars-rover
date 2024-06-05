package ru.pavlentygood.marsrover

class Rover(
    val x: Int,
    val limit: Int,
    val offsetIndex: Int = 0
) {
    private val offsets = arrayOf(1, 0, -1, 0)

    fun step() =
        Rover(
            x = if (x == limit) x else x + offsets[offsetIndex],
            limit = limit
        )

    fun right() =
        Rover(
            x = x,
            limit = limit,
            offsetIndex = (offsetIndex + 1) % offsets.size
        )
}
