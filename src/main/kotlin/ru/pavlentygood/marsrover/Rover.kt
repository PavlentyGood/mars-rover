package ru.pavlentygood.marsrover

class Rover(
    val x: Int,
    val limit: Int,
    val offsetIndex: Int = 0
) {
    private val offsets = arrayOf(1, 0, -1, 0)
    private val offset get() = offsets[offsetIndex]

    fun step() = create(x = if (x == limit) x else x + offset)

    fun right() = create(offsetIndex = (offsetIndex + 1) % offsets.size)

    private fun create(
        x: Int = this.x,
        limit: Int = this.limit,
        offsetIndex: Int = this.offsetIndex) =
        Rover(
            x = x,
            limit = limit,
            offsetIndex = offsetIndex
        )
}
