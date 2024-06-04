package ru.pavlentygood.marsrover

data class Vector(
    val value: Int,
    val limit: Int
) {
    fun next() = step(1, limit)
    fun prev() = step(-1, 0)

    private fun step(offset: Int, constraint: Int) =
        if (value == constraint) this else Vector(value + offset, limit)
}
